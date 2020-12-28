package projecteuler.net;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class alternative11Test {
    private static final int[][] testTABLE = {
            // Горизонтальное произведение всех элементов
            {  2, 10,  5,  3 },  // 300
            { 11,  5,  2,  6 },  // 660
            {  7,  1,  5,  1 },  // 35
            {  4, 10,  2,  1 }   // 80
//           616  500 100  18  - Вертикальное произведение всех элементов
    };

    // преобразователь вызова метода getProduct
    // принимает параметры: x, y, seqLength, String type
    // вызывает getProduct с параметрами: x, y, deltaX, deltaY
    public long invokeGetProduct(int x, int y, int seqLength, String type) {
        alternative11.setSeqLength(seqLength);
        long product = Long.MIN_VALUE;
        switch (type) {
            case "Horizontal" -> product =
                    alternative11.getProduct(x, y, +1,  0);
            case "Vertical"   -> product =
                    alternative11.getProduct(x, y,  0, +1);
            case "rDiagonal"  -> product =
                    alternative11.getProduct(x, y, +1, +1);
            case "lDiagonal"  -> product =
                    alternative11.getProduct(x, y, -1, +1);
            case "Greatest"   -> product =
                    alternative11.findMaxProduct();
        }

        return product;
    }

    @BeforeEach
    void init() {
        alternative11.setTABLE(testTABLE);
    }

    @Test
    void testGetProduct () {
        long p1, p2, p3, p4, p5, p6;
        p1 = invokeGetProduct(1, 2, 3, "Horizontal");
        p2 = invokeGetProduct(1, 2, 4,  "Horizontal");
        p3 = invokeGetProduct(1, 2, 1,  "Vertical");
        p4 = invokeGetProduct(1, 2, 2,  "rDiagonal");
        p5 = invokeGetProduct(1, 2, 2,  "lDiagonal");
        boolean b = p1==5 & p2== Long.MIN_VALUE & p3==1 & p4==2 & p5==4;
        Assertions.assertTrue(b);
    }

    @Test
    @DisplayName( "Максимальное произведение указанной длины" )
    void testFindMaxProduct() {
        alternative11.setSeqLength(4);
        long actual = alternative11.findMaxProduct();
        Assertions.assertEquals(660, actual);
    }
}

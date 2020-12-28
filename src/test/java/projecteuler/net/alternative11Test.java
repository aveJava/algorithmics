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

    /**
     * Возвращает произведение указанного количества чисел, находящихся
     * в указанном направлении относительно элемента testTABLE[3][1]
     * @param seqLength - сколько чисел участвуют в произведении
     * @param expected - ожидаемый результат поиска
     * @param type - тип поиска (по горизонтали, по вертикали и т.д.)
     * @return - true, если результат поиска совпал с ожидаемым
     */
    boolean invokeTest(int seqLength, long expected, String type) {
        alternative11.setSeqLength(seqLength);
        long actual = -1;
        switch (type){
            case "Horizontal" -> actual = alternative11.getHorizontalProd(1, 2);
            case "Vertical" -> actual = alternative11.getVerticalProd(1, 2);
            case "DiagonalRight" -> actual = alternative11.getRDiagonalProd(1, 2);
            case "DiagonalLeft" -> actual = alternative11.getLDiagonalProd(1, 2);
            case "Greatest" -> actual = alternative11.findMaxProduct();
        }
        return actual == expected;
    }

    @BeforeEach
    void init() {
        alternative11.setTABLE(testTABLE);
    }

    @Test
    @DisplayName( "Произведение по горизонтали вправо" )
    void testFindInHorizontal() {
        boolean b1, b2, b3;
        b1  = invokeTest(3, 5, "Horizontal");
        b2 = invokeTest(2, 5, "Horizontal");
        b3 = invokeTest(4, Long.MIN_VALUE, "Horizontal");
        Assertions.assertTrue(b1 & b2 & b3);
    }

    @Test
    @DisplayName( "Произведение по вертикали вниз" )
    void testFindInVertical() {
        boolean b1, b2, b3;
        b1  = invokeTest(1, 1, "Vertical");
        b2 = invokeTest(2, 10, "Vertical");
        b3 = invokeTest(3, Long.MIN_VALUE, "Vertical");
        Assertions.assertTrue(b1 & b2 & b3);
    }

    @Test
    @DisplayName( "Произведение по диагонал сверху вниз вправо" )
    void testFindInRightDiagonal() {
        boolean b1, b2, b3;
        b1  = invokeTest(1, 1, "DiagonalRight");
        b2 = invokeTest(2, 2, "DiagonalRight");
        b3 = invokeTest(3, Long.MIN_VALUE, "DiagonalRight");
        Assertions.assertTrue(b1 & b2 & b3);
    }

    @Test
    @DisplayName( "Произведение по диагонали вниз и влево" )
    void testFindInLeftDiagonal() {
        boolean b1, b2, b3;
        b1  = invokeTest(1, 1, "DiagonalLeft");
        b2 = invokeTest(2, 4, "DiagonalLeft");
        b3 = invokeTest(3, Long.MIN_VALUE, "DiagonalLeft");
        Assertions.assertTrue(b1 & b2 & b3);
    }

    @Test
    @DisplayName( "Максимальное произведение указанной длины" )
    void testFindMaxProduct() {
        Assertions.assertTrue(invokeTest(4, 660, "Greatest"));
    }
}

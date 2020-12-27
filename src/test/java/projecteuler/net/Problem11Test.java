package projecteuler.net;

//TODO Задача 11 - Наибольшее произведение в таблице
// В таблице 20×20 (внизу) четыре числа на одной диагонали выделены красным.
// Произведение этих чисел 26 × 63 × 78 × 14 = 1788696.
// Каково наибольшее произведение четырех подряд идущих чисел в таблице 20×20,
// расположенных в любом направлении (вверх, вниз, вправо, влево или по диагонали)?

import org.junit.jupiter.api.*;

class Problem11Test
{
    private static final int[][] TABLE = {
                                 // Горизонтальное произведение всех элементов
            {  2, 10,  5,  3 },  // 300
            { 11,  5,  2,  6 },  // 660
            {  7,  1,  5,  1 },  // 35
            {  4, 10,  2,  1 }   // 80
//           616  500 100 18  - Вертикальное произведение всех элементов
    };

    /**
     * Выполняет поиск наибольшего произведения указанным способом
     * @param seqLength - сколько чисел участвуют в произведении
     * @param expected - ожидаемый результат поиска
     * @param type - тип поиска (по горизонтали, по вертикали и т.д.)
     * @return - true, если результат поиска совпал с ожидаемым
     */
    boolean invokeTest(int seqLength, long expected, String type) {
        Problem11.setSequenceLength(seqLength);
        long actual = -1;
        switch (type){
            case "Horizontal" -> actual = Problem11.findInHorizontal();
            case "Vertical" -> actual = Problem11.findInVertical();
            case "DiagonalRight" -> actual = Problem11.findInRightDiagonal();
            case "DiagonalLeft" -> actual = Problem11.findInLeftDiagonal();
            case "Greatest" -> actual = Problem11.findGreatestProduct();
        }
        return actual == expected;
    }

    @BeforeEach
    void init() {
        Problem11.setTABLE(TABLE);
    }

    @Test
    @DisplayName( "Проект Эйлера - Задача 11 - Наибольшее произведение по горизонтали" )
    void testHorizontal()
    {
        boolean b1, b2, b3;
        b1 = invokeTest(4, 660, "Horizontal");
        b2 = invokeTest(3, 150, "Horizontal");
        b3 = invokeTest(2, 55, "Horizontal");
        Assertions.assertTrue(b1 & b2 & b3);
    }

    @Test
    @DisplayName( "Проект Эйлера - Задача 11 - Наибольшее произведение по вертикали" )
    void testVertical()
    {
        boolean b1, b2, b3;
        b1 = invokeTest(4, 616, "Vertical");
        b2 = invokeTest(3, 308, "Vertical");
        b3 = invokeTest(2, 77, "Vertical");
        Assertions.assertTrue(b1 & b2 & b3);
    }

    @Test
    @DisplayName( "Проект Эйлера - Задача 11 - Наибольшее произведение диагонал сверху вниз вправо" )
    void testDiagonalRight()
    {
        boolean b1, b2, b3;
        b1 = invokeTest(4, 50, "DiagonalRight");
        b2 = invokeTest(3, 50, "DiagonalRight");
        b3 = invokeTest(2, 70, "DiagonalRight");
        Assertions.assertTrue(b1 & b2 & b3);
    }

    @Test
    @DisplayName( "Проект Эйлера - Задача 11 - Наибольшее произведение диагонали сверху вниз влево" )
    void testDiagonalLeft()
    {
        boolean b1, b2, b3;
        b1 = invokeTest(4, 24, "DiagonalLeft");
        b2 = invokeTest(3, 300, "DiagonalLeft");
        b3 = invokeTest(2, 110, "DiagonalLeft");
        Assertions.assertTrue(b1 & b2 & b3);
    }

    @Test
    @DisplayName( "Проект Эйлера - Задача 11 - Наибольшее произведение по всем направлениям" )
    void testGetGreatestProduct()
    {
        boolean b1, b2, b3;
        b1 = invokeTest(4,660, "Greatest");
        b2 = invokeTest(3, 308, "Greatest");
        b3 = invokeTest(2, 110, "Greatest");
        Assertions.assertTrue(b1 & b2 & b3);
    }
}

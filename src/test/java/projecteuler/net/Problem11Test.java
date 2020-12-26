package projecteuler.net;

//TODO Задача 11 - Наибольшее произведение в таблице
// В таблице 20×20 (внизу) четыре числа на одной диагонали выделены красным.
// Произведение этих чисел 26 × 63 × 78 × 14 = 1788696.
// Каково наибольшее произведение четырех подряд идущих чисел в таблице 20×20,
// расположенных в любом направлении (вверх, вниз, вправо, влево или по диагонали)?

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName( "Проект Эйлера - Задача 11 - Наибольшее произведение по горизонтали" )
    void testHorizontal()
    {
        // Таблица 4х4 и длина последовательности = 4
        int sequenceLength = 4;
        long greatestProductExpected = 660;
        long greatestProductActual = Problem11.findGreatestProductInHorizontal();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );

        // Таблица 4х4 и длина последовательности = 3
        sequenceLength = 3;
        greatestProductExpected = 150;
        greatestProductActual = Problem11.findGreatestProductInHorizontal();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );

        // Таблица 4х4 и длина последовательности = 2
        sequenceLength = 2;
        greatestProductExpected = 55;
        greatestProductActual = Problem11.findGreatestProductInHorizontal();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );
    }

    @Test
    @DisplayName( "Проект Эйлера - Задача 11 - Наибольшее произведение по вертикали" )
    void testVertical()
    {
        // Таблица 4х4 и длина последовательности = 4
        int sequenceLength = 4;
        long greatestProductExpected = 616;
        long greatestProductActual = Problem11.findGreatestProductInVertical();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );

        // Таблица 4х4 и длина последовательности = 3
        sequenceLength = 3;
        greatestProductExpected = 308;
        greatestProductActual = Problem11.findGreatestProductInVertical();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );

        // Таблица 4х4 и длина последовательности = 2
        sequenceLength = 2;
        greatestProductExpected = 77;
        greatestProductActual = Problem11.findGreatestProductInVertical();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );
    }

    @Test
    @DisplayName( "Проект Эйлера - Задача 11 - Наибольшее произведение диагонал сверху вниз вправо" )
    void testDiagonalRight()
    {
        // Таблица 4х4 и длина последовательности = 4
        int sequenceLength = 4;
        long greatestProductExpected = 50;
        long greatestProductActual = Problem11.findGreatestProductInRightDiagonal();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );

        // Таблица 4х4 и длина последовательности = 3
        sequenceLength = 3;
        greatestProductExpected = 50;
        greatestProductActual = Problem11.findGreatestProductInRightDiagonal();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );

        // Таблица 4х4 и длина последовательности = 2
        sequenceLength = 2;
        greatestProductExpected = 70;
        greatestProductActual = Problem11.findGreatestProductInRightDiagonal();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );
    }

    @Test
    @DisplayName( "Проект Эйлера - Задача 11 - Наибольшее произведение диагонали сверху вниз влево" )
    void testDiagonalLeft()
    {
        // Таблица 4х4 и длина последовательности = 4
        int sequenceLength = 4;
        long greatestProductExpected = 24;
        long greatestProductActual = Problem11.findGreatestProductInLeftDiagonal();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );

        // Таблица 4х4 и длина последовательности = 3
        sequenceLength = 3;
        greatestProductExpected = 300;
        greatestProductActual = Problem11.findGreatestProductInLeftDiagonal();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );

        // Таблица 4х4 и длина последовательности = 2
        sequenceLength = 2;
        greatestProductExpected = 110;
        greatestProductActual = Problem11.findGreatestProductInLeftDiagonal();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );
    }

    @Test
    @DisplayName( "Проект Эйлера - Задача 11 - Наибольшее произведение по всем направлениям" )
    void testGetGreatestProduct()
    {
        // Таблица 4х4 и длина последовательности = 4
        int sequenceLength = 4;
        long greatestProductExpected = 660;
        long greatestProductActual = Problem11.findGreatestProduct();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );

        // Таблица 4х4 и длина последовательности = 3
        sequenceLength = 3;
        greatestProductExpected = 308;
        greatestProductActual = Problem11.findGreatestProduct();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );

        // Таблица 4х4 и длина последовательности = 2
        sequenceLength = 2;
        greatestProductExpected = 110;
        greatestProductActual = Problem11.findGreatestProduct();
        Assertions.assertEquals( greatestProductExpected, greatestProductActual );
    }
}

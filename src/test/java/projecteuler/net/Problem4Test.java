package projecteuler.net;

//TODO Задача 4 - Наибольшее произведение-палиндром
// Число-палиндром с обеих сторон (справа налево и слева направо) читается одинаково.
// Самое большое число-палиндром, полученное умножением двух двузначных чисел – 9009 = 91 × 99.
// Найдите самый большой палиндром, полученный умножением двух трехзначных чисел.

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Problem4Test
{
    @Test
    @DisplayName( "Проект Эйлера - Задача 4 - Длина числа" )
    void testGetNumberLength()
    {
        // Положительные числа
        Assertions.assertEquals( 1, Problem4.getNumberLength( 0 ));
        Assertions.assertEquals( 1, Problem4.getNumberLength( 1 ));
        Assertions.assertEquals( 2, Problem4.getNumberLength( 12 ));
        Assertions.assertEquals( 3, Problem4.getNumberLength( 123 ));
        Assertions.assertEquals( 4, Problem4.getNumberLength( 1234 ));
        Assertions.assertEquals( 5, Problem4.getNumberLength( 12345 ));

        // Отрицательные числа
        Assertions.assertEquals( 1, Problem4.getNumberLength( -1 ));
        Assertions.assertEquals( 2, Problem4.getNumberLength( -12 ));
        Assertions.assertEquals( 3, Problem4.getNumberLength( -123 ));
        Assertions.assertEquals( 4, Problem4.getNumberLength( -1234 ));
        Assertions.assertEquals( 5, Problem4.getNumberLength( -12345 ));
    }

    @Test
    @DisplayName( "Проект Эйлера - Задача 4 - Разделение числа на элементы массива" )
    void testSplitNumberOnParts()
    {
        Assertions.assertArrayEquals( new int[]{ 1 }, Problem4.splitNumberOnParts( 1 ));
        Assertions.assertArrayEquals( new int[]{ 1, 2 }, Problem4.splitNumberOnParts( 12 ));
        Assertions.assertArrayEquals( new int[]{ 1, 2, 3 }, Problem4.splitNumberOnParts( 123 ));
        Assertions.assertArrayEquals( new int[]{ 1, 2, 3, 4 }, Problem4.splitNumberOnParts( 1234 ));
        Assertions.assertArrayEquals( new int[]{ 1, 2, 3, 4, 5 }, Problem4.splitNumberOnParts( 12345 ));
        Assertions.assertArrayEquals( new int[]{ -1, 2, 3, 4, 5 }, Problem4.splitNumberOnParts( -12345 ));
        Assertions.assertArrayEquals( new int[]{ -1 }, Problem4.splitNumberOnParts( -1 ));
    }

    @Test
    @DisplayName( "Проект Эйлера - Задача 4 - Определение полиндрома" )
    void testIsPalindrome()
    {
        Assertions.assertTrue( Problem4.isPalindrome( 9009 ));
        Assertions.assertFalse( Problem4.isPalindrome( 1234 ));
    }

    //TODO Самое большое число-палиндром, полученное умножением двух двузначных чисел – 9009 = 91 × 99.
    @Test
    @DisplayName( "Проект Эйлера - Задача 4 - Палиндром: 9009 = 91 × 99" )
    void testPalindrome9009()
    {
        int[] expected = { 9009, 99, 91 };
        int[] actual = Problem4.getSolution( 99 );

        Assertions.assertArrayEquals( expected, actual );
    }
}

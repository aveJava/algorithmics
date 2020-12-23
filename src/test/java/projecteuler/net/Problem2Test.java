package projecteuler.net;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//TODO Задача 2 - Четные числа Фибоначчи
// Каждый следующий элемент ряда Фибоначчи получается при сложении двух предыдущих.
// Начиная с 1 и 2, первые 10 элементов будут:
// 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
// Найдите сумму всех четных элементов ряда Фибоначчи, которые не превышают четыре миллиона.

class Problem2Test
{
    //TODO Начиная с 1 и 2, первые 10 элементов будут:
    // 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
    // Найдите сумму всех четных элементов ряда Фибоначчи
    @Test
    @DisplayName( "Проект Эйлера - Задача 2 - Длина последовательности: 10" )
    void testCase1()
    {
        int[] numbersExpected = { 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        long sumExpected = 44;

        int[] numbersActual = Problem2.getFibonacciSequence( 10 );
        long sumActual = Problem2.getSumOfEvenElements( numbersActual );

        Assertions.assertEquals( sumExpected, sumActual );
        Assertions.assertArrayEquals( numbersExpected, numbersActual );
    }
}

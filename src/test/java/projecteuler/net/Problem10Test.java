package projecteuler.net;

//TODO Задача 10 - Сложение простых чисел
// Сумма простых чисел меньше 10 равна 2 + 3 + 5 + 7 = 17.
// Найдите сумму всех простых чисел меньше двух миллионов.

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Problem10Test
{
    //TODO Простые числа меньше 10: 2 + 3 + 5 + 7.
    @Test
    @DisplayName( "Проект Эйлера - Задача 10 - Простые числа меньше 10: 2 + 3 + 5 + 7" )
    void testCase1()
    {
        int[] expected = { 2, 3, 5, 7 };
        int[] actual = Problem10.getSimpleNumbersInRange( 1, 10 );

        Assertions.assertArrayEquals( expected, actual );
    }

    //TODO Сумма простых чисел меньше 10 равна 17.
    @Test
    @DisplayName( "Проект Эйлера - Задача 10 - Сумма простых чисел меньше 10 равна 17." )
    void testCase2()
    {
        int[] array = { 2, 3, 5, 7 };
        long sumExpected = 17;
        long sumActual = Problem10.getSumOfArray( array );

        Assertions.assertEquals( sumExpected, sumActual );
    }
}

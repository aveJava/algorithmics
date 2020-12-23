package projecteuler.net;

//TODO Задача 3 - Наибольший простой делитель
// Простые делители числа 13195 - это 5, 7, 13 и 29.
// Каков самый большой делитель числа 600851475143, являющийся простым числом?

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Problem3Test
{
    //TODO Простые числа 5, 7, 13, 29
    @Test
    @DisplayName( "Проект Эйлера - Задача 3 - Определение простого числа" )
    void testIsNumberSimple()
    {
        int[] simpleNumbers = { 5, 7, 13, 29 };

        for( int number : simpleNumbers )
        {
            Assertions.assertTrue( Problem3.isNumberSimple( number ));
        }
    }

    //TODO Простые делители числа 13195 - это 5, 7, 13 и 29.
    @Test
    @DisplayName( "Проект Эйлера - Задача 3 - Простые делители числа 13195" )
    void testSimpleDividersOfNumbers()
    {
        int number = 13195;

        int[] simpleDividersExpected = { 5, 7, 13, 29 };
        long[] simpleDividersActual = Problem3.getSimpleDividersOfNumber( number );

        // Сравнение элементов массива т.к. длина может отличаться
        // Считать длину массива по первому встретившемуся нулевому элементу.
        for ( int i = 0; i < simpleDividersActual.length; i++ )
        {
            if( simpleDividersActual[ i ] == 0 ) {
                break;
            }
            Assertions.assertEquals( simpleDividersExpected[ i ], simpleDividersActual[ i ]);
        }
    }
}

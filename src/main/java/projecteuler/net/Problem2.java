package projecteuler.net;

//TODO Задача 2 - Четные числа Фибоначчи
// Каждый следующий элемент ряда Фибоначчи получается при сложении двух предыдущих.
// Начиная с 1 и 2, первые 10 элементов будут:
// 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
// Найдите сумму всех четных элементов ряда Фибоначчи, которые не превышают четыре миллиона.

public class Problem2
{
    public static void main( String[] args )
    {
        int[] array = getFibonacciSequence( 4_000_000 );
        long sumOfEvenElements = getSumOfEvenElements( array );

        System.out.println( "\nсумма четных элементов: " + sumOfEvenElements );
    }

    static int[] getFibonacciSequence( int length )
    {
        // Массив заданной длины ряда
        int[] array = new int[ length ];

        // Начальные данные ряда Фибоначчи
        array[0] = 1;
        array[1] = 2;

        for( int i = 2; i < length; i++ )
        {
            array[ i ] = array[ i - 1 ] + array[ i - 2 ];
        }

        return array;
    }

    static long getSumOfEvenElements( int[] array )
    {
        long sum = 0;
        for( int number : array )
        {
            if( number % 2 == 0 ) {
                sum += number;
            }
        }
        return sum;
    }
}

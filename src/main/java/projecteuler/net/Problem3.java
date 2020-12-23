package projecteuler.net;

//TODO Задача 3 - Наибольший простой делитель
// Простые делители числа 13195 - это 5, 7, 13 и 29.
// Каков самый большой делитель числа 600851475143, являющийся простым числом?

//TODO Текущее решение очень медленное, необходимо оптимизировать алгоритм.

public class Problem3
{
    public static void main( String[] args )
    {
        long givenNumber = 600_851_475_143L;
        long[] simpleDividers = getSimpleDividersOfNumber( givenNumber );

        System.out.print( "Дано число: " + givenNumber + "\nПростые делители: " );
        for( long number : simpleDividers )
        {
            if ( number == 0 ) {
                break;
            }
            System.out.print( number + ", " );
        }
    }

    /**
     * Алгоритм нахождения простого числа.
     * Простое число делиться без остатка только на 1 и на само себя.
     * Если в ходе цикла число смогло поделиться без остатка, значит оно не является простым.
     * Цикл должен пройти все итерации, если число является простым.
     */
    static boolean isNumberSimple( long number )
    {
        // Простое число должно быть больше 1
        if( number <= 1 )
            return false;

        // Простое число должно делиться без остатка на 1 и на само себя
        for( int i = 2; i < number; i++ )
        {
            // Данное число поделилось без остатка, следовательно оно не является простым
            if( number % i == 0 ) {
                return false;
            }
        }

        return true;
    }

    /**
     * Добавляет простые делители заданного числа в массив, если:
     * 1. Делитель является простым числом
     * 2. Заданное число делится на простой делитель без остатка
     */
    static long[] getSimpleDividersOfNumber( long number )
    {
        long[] simpleDividers = new long[ 1_000 ];
        int currentArrayElement = 0;

        for( long i = 2; i < number; i++ )
        {
            if( isNumberSimple( i ) && number % i == 0 )
            {
                simpleDividers[ currentArrayElement++ ] = i;
                System.out.println( i );
            }
        }

        return simpleDividers;
    }
}

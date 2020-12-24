package projecteuler.net;

//TODO Задача 10 - Сложение простых чисел
// Сумма простых чисел меньше 10 равна 2 + 3 + 5 + 7 = 17.
// Найдите сумму всех простых чисел меньше двух миллионов.

/**
 * В этой задаче 10 будет использован метод isNumberSimple() из решения задачи 3 (Problem3)
 */

class Problem10
{
    public static void main( String[] args )
    {
        int[] simpleNumbers = getSimpleNumbersInRange( 1, 2_000_000 );
        long sum = getSumOfArray( simpleNumbers );
        
        System.out.println( "Сумма всех простых чисел меньше двух миллионов: " + sum );
    }

    static int[] getSimpleNumbersInRange( int from, int to )
    {
        // Промежуточный массив бОльшей емкости (заранее неизвестно, сколько будет найдено чисел)
        int[] numbers = new int[ to ];
        int currentArrayElement = 0;

        // Поиск простых чисел в диапазоне from to
        for( int i = from; i <= to; i++ )
        {
            // Если число простое, добавить его в промежуточный массив
            if( Problem3.isNumberSimple( i ))
            {
                numbers[ currentArrayElement++ ] = i;
            }
        }

        // Т.к. промежуточный массив (numbers) содержит нулевые значения
        // Необходимо сформировать результирующий массив без нулевых значений и вернуть его
        int[] result = new int[ currentArrayElement ];

        for( int i = 0; i < result.length; i++ ) {
            result[ i ] = numbers[ i ];
        }

        return result;
    }

    static long getSumOfArray( int[] array )
    {
        long sum = 0;

        for (int number : array ) {
            sum += number;
        }

        return sum;
    }
}

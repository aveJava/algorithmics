package projecteuler.net;

//TODO Задача 4 - Наибольшее произведение-палиндром
// Число-палиндром с обеих сторон (справа налево и слева направо) читается одинаково.
// Самое большое число-палиндром, полученное умножением двух двузначных чисел – 9009 = 91 × 99.
// Найдите самый большой палиндром, полученный умножением двух трехзначных чисел.

class Problem4
{
    public static void main( String[] args )
    {
        int[] result = getSolution( 999 );

        System.out.format( "%d = %d x %d", result[ 0 ], result[ 1 ], result[ 2 ]);
    }

    /**
     * Т.к. требуется найти самый бОльший палиндром, полученный умножением двух
     * трехзначных чисел, то будем вести расчет с конца т.е. с самых больших множителей 999 × 999.
     * @param - multiplier максимальный множитель
     * @return массив, в котором:
     * [0] - число палиндром
     * [1] - первый трехзначный множитель
     * [2] - второй трехзначный множитель
     *
     */
    static int[] getSolution( int multiplier )
    {
        // Перемножаем множители и проверяем результат на палиндром
        // Первое совпадение  будет решением
        for ( int secondMultiplier = multiplier; secondMultiplier > 0; secondMultiplier-- )
        {
            int result = multiplier * secondMultiplier;
            if ( isPalindrome( result ))
            {
                return new int[]{ result, multiplier, secondMultiplier };
            }
        }

        return new int[3];
    }
    
    static boolean isPalindrome( int number )
    {
        // Преобразуем число в цифры и сохраняем в массив
        int[] numberAsArray = splitNumberOnParts( number );

        // Является ли переданное числа палиндромом
        for ( int i = 0; i < numberAsArray.length; i++ )
        {
            // Сравниваем первую цифру с последней
            if ( numberAsArray[ i ] != numberAsArray[ numberAsArray.length - 1 - i ]) {
                return false;
            }
        }

        return true;
    }

    static int[] splitNumberOnParts( int number )
    {
        // Создать результирующий массив заданной длины
        int numberLength = getNumberLength( number );
        int[] result = new int[ numberLength];

        // Ставим флаг, если переданное число отрицательное
        boolean isNumberNegative = number < 0;

        // Переводит переданное число в положительное
        if ( isNumberNegative ) {
            number *= -1;
        }

        // Заполнять массив с конца, тогда будет правильный порядок числа в итоговом массиве
        int lastIndex = numberLength - 1;

        for ( int i = 0; i < numberLength; i++ )
        {
            // Получаем последнюю цифру числа в массив
            result[ lastIndex - i ] = number % 10;

            // Отбрасываем последнюю цифру числа
            number /= 10;
        }

        // Изменить знак первого элемента массива на отрицательный
        if ( isNumberNegative )
        {
            result[ 0 ] *= -1;
        }

        return result;
    }

    static int getNumberLength( int number )
    {
        if ( number == 0 ) {
            return 1;
        }

        int length = 0;

        // Делим число пока оно не равно 0
        while( number != 0 )
        {
            // Отбрасываем последний разряд
            number /= 10;
            length++;
        }

        return length;
    }
}

package projecteuler.net;

//TODO Задача 1 - Числа, кратные 3 или 5
// Если выписать все натуральные числа меньше 10, кратные 3 или 5,
// то получим 3, 5, 6 и 9. Сумма этих чисел равна 23.
// Найдите сумму всех чисел меньше 1000, кратных 3 или 5.

public class Problem1
{
    public static void main( String[] args )
    {
        int[] numbers = getNaturalNumbers( 1000 );
        int sum = getArraySum( numbers );

        // Печатаем результат
        System.out.println( "\nActual array: ");
        for( int number : numbers ) {
            System.out.print( number + ", ");
        }
        System.out.println( "\nДлина массива: " + numbers.length + "\nСумма чисел: " + sum );
    }

    static int[] getNaturalNumbers( int numberCount )
    {
        // Решение
        int[] numbers = new int[ numberCount ];

        // Текущий элемент массива при заполнении массива numbersActual
        int currentArrayIndex = 0;

        // Множители кратные 3 и 5
        int multiplier3 = 3;
        int multiplier5 = 5;
        for ( int number = 1; number < numberCount ; number++ )
        {
            // Число кратное 3
            if( number % multiplier3 == 0 ) {
                numbers[ currentArrayIndex++ ] = number;
                continue;
            }

            // Число кратное 5
            if( number % multiplier5 == 0 )
            {
                numbers[ currentArrayIndex++ ] = number;
            }
        }
        return numbers;
    }

    static int getArraySum( int[] array )
    {
        int sum = 0;
        for ( int number : array )
        {
            // Выйти из цикла, если в массиве пошли нулевые числа
            if ( number == 0 ) {
                break;
            }
            sum += number;
        }
        return sum;
    }
}

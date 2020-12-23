package projecteuler.net;

//TODO Задача 7 - 10001-ое простое число
// Выписав первые шесть простых чисел, получим 2, 3, 5, 7, 11 и 13. Очевидно, что 6-ое простое число - 13.
// Какое число является 10001-ым простым числом?

/**
 * В этой задаче 7 будет использован метод isNumberSimple() из решения задачи 3 (Problem3)
 */

class Problem7
{
    public static void main( String[] args )
    {
        int position = 10_001;
        int result = getSimpleNumberAtPosition( position );

        System.out.format( "10001-ым простым числов является число: %d", result );
    }

    /**
     * @param position - n-ое простое число в бесконечной последовательности
     * @return Возвращает простое число, которое находится n-ым по счету
     */
    static int getSimpleNumberAtPosition( int position )
    {
        // Последнее найденное простое число
        int lastSimpleNumber = 0;

        // Текущее простое число по счету (позиция в бесконечной последовательности)
        int currentPosition = 0;

        // Начать поиск простых чисел с числа number
        int number = 2;

        while( currentPosition != position )
        {
            if ( Problem3.isNumberSimple( number )) {
                currentPosition++;
                lastSimpleNumber = number;
            }
            number++;
        }

        return lastSimpleNumber;
    }
}

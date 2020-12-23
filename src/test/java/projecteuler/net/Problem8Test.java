package projecteuler.net;

//TODO Задача 8 - Наибольшее произведение в последовательности
// Наибольшее произведение четырех последовательных цифр в нижеприведенном 1000-значном числе равно 9 × 9 × 8 × 9 = 5832.
// Найдите наибольшее произведение тринадцати последовательных цифр в данном числе.

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Problem8Test
{
    // Заданное 1000-значное число
    private static final int[] hugeNumber = Problem8.hugeNumber;

    // Последний индекс 1000-значного числа
    private static final int lastIndexOfHugeNumber = hugeNumber.length - 1;


    //TODO Наибольшее произведение четырех последовательных цифр в нижеприведенном
    // 1000-значном числе равно 9 × 9 × 8 × 9 = 5832.
    @Test
    @DisplayName( "Проект Эйлера - Задача 8 - Последовательность 9 × 9 × 8 × 9 = 5832" )
    void testSequence5832()
    {
        int sequenceLength = 4;
        long expected = 5832;
        long actual = Problem8.getLargestMultiplicationOfSequence( sequenceLength );

        Assertions.assertEquals( expected, actual );
    }
}

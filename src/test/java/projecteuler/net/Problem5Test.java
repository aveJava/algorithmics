package projecteuler.net;

//TODO Задача 5 - Наименьшее кратное
// 2520 - самое маленькое число, которое делится без остатка на все числа от 1 до 10.
// Какое самое маленькое число делится нацело на все числа от 1 до 20?

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Problem5Test
{
    //TODO 2520 - самое маленькое число, которое делится без остатка на все числа от 1 до 10.
    @Test
    @DisplayName( "Проект Эйлера - Задача 5 - Наименьшее кратное 2520 для чисел 1 - 10" )
    void testFrom1To10()
    {
        int from = 1;
        int to = 10;

        int expected = 2520;
        int actual = Problem5.getSolution( from, to );

        Assertions.assertEquals( expected, actual );
    }

    //TODO 232792560 - самое маленькое число делится нацело на все числа от 1 до 20.
    @Test
    @DisplayName( "Проект Эйлера - Задача 5 - Наименьшее кратное для чисел 1 - 20" )
    void testFrom1To20()
    {
        int from = 1;
        int to = 20;

        int expected = 232792560;
        int actual = Problem5.getSolution( from, to );

        Assertions.assertEquals( expected, actual );
    }
}

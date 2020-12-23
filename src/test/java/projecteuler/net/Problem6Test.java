package projecteuler.net;

//TODO Сумма квадратов первых десяти натуральных чисел равна:
// 1^2 + 2^2 + ... + 10^2 = 385
// Квадрат суммы первых десяти натуральных чисел равен:
// (1 + 2 + ... + 10)^2 = 55^2 = 3025
// Следовательно, разность между суммой квадратов и квадратом суммы первых десяти натуральных чисел составляет:
// 3025 − 385 = 2640.
// Найдите разность между суммой квадратов и квадратом суммы первых ста натуральных чисел.

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Problem6Test
{
    //TODO Сумма квадратов первых десяти натуральных чисел равна:
    // 1^2 + 2^2 + ... + 10^2 = 385
    @Test
    @DisplayName( "Проект Эйлера - Задача 6 - Сумма квадратов от 0 до 10 = 385" )
    void testGetSumOfSquares()
    {
        int numberCount = 10;
        int expected = 385;
        int actual = Problem6.getSumOfSquares( numberCount );

        Assertions.assertEquals( expected, actual );
    }

    //TODO Квадрат суммы первых десяти натуральных чисел равен:
    // (1 + 2 + ... + 10)^2 = 55^2 = 3025
    @Test
    @DisplayName( "Проект Эйлера - Задача 6 - Квадрат суммы от 0 до 10 = 3025" )
    void testGetSquareOfSum()
    {
        int numberCount = 10;
        int expected = 3025;
        int actual = Problem6.getSquareOfSum( numberCount );

        Assertions.assertEquals( expected, actual );
    }
}

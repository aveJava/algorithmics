package projecteuler.net;

//TODO Задача 7 - 10001-ое простое число
// Выписав первые шесть простых чисел, получим 2, 3, 5, 7, 11 и 13. Очевидно, что 6-ое простое число - 13.
// Какое число является 10001-ым простым числом?

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Problem7Test
{
    //TODO Выписав первые шесть простых чисел, получим 2, 3, 5, 7, 11 и 13.
    // Очевидно, что 6-ое простое число - 13.
    @Test
    @DisplayName( "Проект Эйлера - Задача 7 - На 6-ом месте, простое число 13" )
    void testCase1()
    {
        int position = 6;
        int expected = 13;
        int actual = Problem7.getSimpleNumberAtPosition( position );

        Assertions.assertEquals( expected, actual );
    }
}

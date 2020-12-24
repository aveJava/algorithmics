package projecteuler.net;

//TODO Задача 9 - Особая тройка Пифагора
// Тройка Пифагора - три натуральных числа a < b < c, для которых выполняется равенство
// a^2 + b^2 = c^2
// Например, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
// Существует только одна тройка Пифагора, для которой a + b + c = 1000.
// Найдите произведение abc.

class Problem9
{
    public static void main( String[] args )
    {
        int sum = 1000;

        // Множитель a
        for( int i = 2; i < sum; i++ )
        {
            int a = i * i;

            // Множитель b
            for( int j = 2; j < sum; j++ )
            {
                int b = j * j;

                // Множитель c
                for( int k = 2; k < sum; k++ )
                {
                    int c = k * k;

                    // Найдена тройка множителей
                    if (( a + b + c ) == sum )
                    {
                        System.out.format( "%d + %d + %d = %d\n", a, b, c, sum );
                        System.out.printf( "a = %d;\nb = %d;\nc = %d;\n", a, b, c );

                        a = (int) Math.sqrt( a );
                        b = (int) Math.sqrt( b );
                        c = (int) Math.sqrt( c );
                        System.out.printf( "a^2 = %d;\nb^2 = %d;\nc^2 = %d;\n", a, b, c );

                        int result = a * b * c;
                        System.out.printf( "abc = %d", result );

                        return;
                    }
                }
            }
        }
    }
}

package projecteuler.net;

//TODO Сумма квадратов первых десяти натуральных чисел равна:
// 1^2 + 2^2 + ... + 10^2 = 385
// Квадрат суммы первых десяти натуральных чисел равен:
// (1 + 2 + ... + 10)^2 = 55^2 = 3025
// Следовательно, разность между суммой квадратов и квадратом суммы первых десяти натуральных чисел составляет:
// 3025 − 385 = 2640.
// Найдите разность между суммой квадратов и квадратом суммы первых ста натуральных чисел.

class Problem6
{
    public static void main( String[] args )
    {
        int numberCount = 100;
        int squareOfSum = getSquareOfSum( numberCount );
        int sumOfSquares = getSumOfSquares( numberCount );

        int result = squareOfSum - sumOfSquares;

        System.out.printf( "Квадрат суммы = %d, сумма квадратов = %d, разность = %d", squareOfSum, sumOfSquares, result );
    }


    static int getSumOfSquares( int numberCount )
    {
        int sum = 0;

        for ( int number = 1; number <= numberCount; number++ ) {
            sum += number * number;
        }

        return sum;
    }

    
    static int getSquareOfSum( int numberCount )
    {
        int sum = 0;

        for ( int number = 1; number <= numberCount; number++ ) {
            sum += number;
        }

        return sum * sum;
    }
}

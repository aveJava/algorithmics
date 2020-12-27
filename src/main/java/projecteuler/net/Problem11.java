package projecteuler.net;

//TODO Задача 11 - Наибольшее произведение в таблице
// В таблице 20×20 (внизу) четыре числа на одной диагонали выделены красным.
// Произведение этих чисел 26 × 63 × 78 × 14 = 1788696.
// Каково наибольшее произведение четырех подряд идущих чисел в таблице 20×20,
// расположенных в любом направлении (вверх, вниз, вправо, влево или по диагонали)?

import java.util.ArrayList;
import java.util.Collections;

class Problem11
{
    private static final int[][] constantTABLE = {
            {  8,  2, 22, 97, 38, 15,  0, 40,  0, 75,  4,  5,  7, 78, 52, 12, 50, 77, 91,  8 },
            { 49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48,  4, 56, 62,  0 },
            { 81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30,  3, 49, 13, 36, 65 },
            { 52, 70, 95, 23,  4, 60, 11, 42, 69, 24, 68, 56,  1, 32, 56, 71, 37,  2, 36, 91 },
            { 22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80 },
            { 24, 47, 32, 60, 99,  3, 45,  2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50 },
            { 32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70 },
            { 67, 26, 20, 68,  2, 62, 12, 20, 95, 63, 94, 39, 63,  8, 40, 91, 66, 49, 94, 21 },
            { 24, 55, 58,  5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72 },
            { 21, 36, 23,  9, 75,  0, 76, 44, 20, 45, 35, 14,  0, 61, 33, 97, 34, 31, 33, 95 },
            { 78, 17, 53, 28, 22, 75, 31, 67, 15, 94,  3, 80,  4, 62, 16, 14,  9, 53, 56, 92 },
            { 16, 39,  5, 42, 96, 35, 31, 47, 55, 58, 88, 24,  0, 17, 54, 24, 36, 29, 85, 57 },
            { 86, 56,  0, 48, 35, 71, 89,  7,  5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58 },
            { 19, 80, 81, 68,  5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77,  4, 89, 55, 40 },
            {  4, 52,  8, 83, 97, 35, 99, 16,  7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66 },
            { 88, 36, 68, 87, 57, 62, 20, 72,  3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69 },
            {  4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18,  8, 46, 29, 32, 40, 62, 76, 36 },
            { 20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74,  4, 36, 16 },
            { 20, 73, 35, 29, 78, 31, 90,  1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57,  5, 54 },
            {  1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52,  1, 89, 19, 67, 48 }
    };
    private static int sequenceLength = 4;
    private static int[][] TABLE = constantTABLE;

    public static void main( String[] args )
    {
        Problem11.reset();
        long result = findGreatestProduct();

        System.out.println( "Наибольшее произведение четырех подряд идущих чисел расположенных в любом направлении: " + result );
    }

    // вызывает все методы поиска и возвращает наибольший найденный результат
    static long findGreatestProduct()
    {
        ArrayList<Long> list = new ArrayList<>();
        list.add(findInHorizontal());       // Направление - вправо
        list.add(findInVertical());         // Направление - вниз
        list.add(findInRightDiagonal());    // Направление - диагональ вправо
        list.add(findInLeftDiagonal());     // Направление - диагональ влево
        Collections.sort(list);
        return list.get(3);     // возвращает самое большое найденное значение
    }

    /**
     * Считает произведение элементов по горизонтали в направлении слева направо
     * @return - наибольшее произведение
     */
    static long findInHorizontal()
    {
        // Наибольшее произведение по горизонтали
        long result = 1;

        // Перебираем строки
        for( int row = 0; row < TABLE.length; row++ )
        {
            // Последний индекс в строке, при котором умещается последовательность
            int lastColumn = TABLE[ row ].length - sequenceLength;

            // Перебираем столбцы в строке
            for( int column = 0; column <= lastColumn; column++ )
            {
                // Текущее произведение элементов
                long currentProduct = 1;

                // Устанавливаем границы для текущей последовательности элементов
                int endElement = column + sequenceLength - 1;

                // Умножаем последовательно идущие элементы
                for( int element = column; element <= endElement; element++ )
                {
                    currentProduct *= TABLE[ row ][ element ];
                }

                // Наибольшее произведение на данный момент
                result = Math.max( result, currentProduct );
            }
        }

        return result;
    }

    /**
     * Считает произведение элементов по вертикали в направлении сверху вниз
     * @return - наибольшее произведение
     */
    static long findInVertical()
    {
        // Наибольшее произведение по вертикали
        long result = 1;

        // Последняя строка, в которой умещается последовательность
        int lastRow = TABLE.length - sequenceLength;

        // Перебираем строки
        for( int row = 0; row <= lastRow; row++ )
        {
            // Перебираем столбцы в строке
            for( int column = 0; column < TABLE[ row ].length; column++ )
            {
                // Текущее произведение элементов
                long currentProduct = 1;

                // Устанавливаем границы для текущей последовательности элементов
                int endElement = row + sequenceLength - 1;

                // Умножаем последовательно идущие элементы
                for( int element = row; element <= endElement; element++ )
                {
                    currentProduct *= TABLE[ element ][ column ];
                }

                // Наибольшее произведение на данный момент
                result = Math.max( result, currentProduct );
            }
        }

        return result;
    }

    /**
     * Считает произведение элементов по диагонали в направлении вправо сверху вниз
     * @return - наибольшее произведение
     */
    static long findInRightDiagonal()
    {
        // Наибольшее произведение по диагонали сверху вниз вправо
        long result = 1;

        // Последняя строка в таблице, при которой вмещается вся диагональ
        int lastRow = TABLE.length - sequenceLength;

        // Перебираем строки
        for( int row = 0; row <= lastRow; row++ )
        {
            // Последний индекс в строке, при котором вмещается вся диагональ
            int lastColumn = TABLE[ row ].length - sequenceLength;

            // Перебираем столбцы в строке
            for( int column = 0; column <= lastColumn; column++ )
            {
                // Текущее произведение элементов
                long currentProduct = 1;

                // Устанавливаем границы для текущей последовательности элементов
                int rowElement = row - 1;     // якорь начала диагонали
                int endElement = column + sequenceLength - 1;   // последний элемент диагонали

                // Умножаем последовательно идущие элементы
                for( int columnElement = column; columnElement <= endElement; columnElement++ )
                {
                    // Перемножаем элементы диагонали в направлении сверху вниз вправо
                    currentProduct *= TABLE[ ++rowElement ][ columnElement ];
                }

                // Наибольшее произведение на данный момент
                result = Math.max( result, currentProduct );
            }
        }

        return result;
    }

    /**
     * Считает произведение элементов по диагонали в направлении влево сверху вниз
     * @return - наибольшее произведение
     */
    static long findInLeftDiagonal()
    {
        // Наибольшее произведение по диагонали сверху вниз влево
        long result = 1;

        // Последняя строка в таблица, при которой вмещается вся диагональ
        int lastRow = TABLE.length - sequenceLength;

        // Перебираем строки
        for( int row = 0; row <= lastRow; row++ )
        {
            // Последний индекс в строке, при котором вмещается вся диагональ
            int lastColumn = sequenceLength - 1;

            // Перебираем столбцы в строке в обратном порядке
            for( int column = TABLE[ row ].length - 1; column >= lastColumn; column-- )
            {
                // Текущее произведение элементов
                long currentProduct = 1;

                // Устанавливаем границы для текущей последовательности элементов
                int rowElement = row - 1;     // якорь начала диагонали
                int endElement = column - sequenceLength + 1;   // последний элемент диагонали

                // Умножаем последовательно идущие элементы
                for( int columnElement = column; columnElement >= endElement; columnElement-- )
                {
                    // Перемножаем элементы диагонали в направлении сверху вниз влево
                    currentProduct *= TABLE[ ++rowElement ][ columnElement ];
                }

                // Наибольшее произведение на данный момент
                result = Math.max( result, currentProduct );
            }
        }

        return result;
    }

    static public void reset() {
        TABLE = constantTABLE;
        sequenceLength = 4;
    }

    public static void setTABLE(int[][] TABLE) {
        Problem11.TABLE = TABLE;
    }

    public static void setSequenceLength(int sequenceLength) {
        Problem11.sequenceLength = sequenceLength;
    }
}

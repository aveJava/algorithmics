package projecteuler.net;

import java.util.stream.LongStream;

public class Problem11x {
    private static int seqLength = 4;
    private static final int[][] TABLE = {
            // Горизонтальное произведение всех элементов
            {  2, 10,  5,  3 },  // 300
            { 11,  5,  2,  6 },  // 660
            {  7,  1,  5,  1 },  // 35
            {  4, 10,  2,  1 }   // 80
//           616  500 100 18  - Вертикальное произведение всех элементов
    };

    public static void main(String[] args) {
        System.out.println(findMaxProduct());
    }

    public static long findMaxProduct() {
        long horizontal, vertical, rightDiagonal, leftDiagonal;
        long currentResult = -1;    // текущий результат

        // для каждого элемента TABLE выполняем следующий цикл
        for (int x = 0; x < TABLE[0].length; x++) {
            for (int y = 0; y < TABLE.length; y++) {
                // произведения, найденные в разных направлениях, 
                // относительно текущего элемента
                horizontal = findInHorizontal(x, y);
                vertical = findInVertical(x, y);
                rightDiagonal = findInRightDiagonal(x, y);
                leftDiagonal = findInLeftDiagonal(x, y);

                currentResult = LongStream.of(currentResult,
                        horizontal, vertical, rightDiagonal, leftDiagonal)
                        .max()
                        .getAsLong();
            }
        }

        return currentResult;
    }

    // возвращает произведение  чисел (количество чисел = seqLength),
    // расположенных по горизонтали вправо от элемента с координатами
    // x и y, включая сам этот элемент
    public static long findInHorizontal(int x, int y) {
        int product = TABLE[x][y];
        if (TABLE[y].length < x + seqLength) return product;
        for (int i = 1; i < seqLength; i++) {
            product *= TABLE[x+i][y];
        }
        return product;
    }

    // поиск по вертикали вниз 
    public static long findInVertical(int x, int y) {
        int product = TABLE[x][y];
        if (TABLE.length < y + seqLength) return product;
        for (int i = 1; i < seqLength; i++) {
            product *= TABLE[x][y+i];
        }
        return product;
    }

    // поиск по диагонали вправо вниз 
    public static long findInRightDiagonal(int x, int y) {
        int product = TABLE[x][y];
        if (TABLE[y].length < x + seqLength ||
                TABLE.length < y + seqLength) return product;
        for (int i = 1; i < seqLength; i++) {
            product *= TABLE[x+i][y+i];
        }
        return product;
    }

    // поиск по диагонали влево вниз
    public static long findInLeftDiagonal(int x, int y) {
        int product = TABLE[x][y];
        if (TABLE[y].length < y + seqLength ||
            x - seqLength < 0) return product;
        for (int i = 1; i < seqLength; i++) {
            product *= TABLE[x-i][y+i];
        }
        return product;
    }

}

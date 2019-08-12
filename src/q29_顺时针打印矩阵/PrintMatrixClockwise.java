package q29_顺时针打印矩阵;

public class PrintMatrixClockwise {
    public static void main(String[] args) {
        test(1, 1);
        test(2, 2);
        test(4, 4);
        test(5, 5);
        test(1, 5);
        test(2, 5);
        test(3, 5);
        test(4, 5);
        test(5, 1);
        test(5, 2);
        test(5, 3);
        test(5, 4);
    }

    private static void printMatrixClockwise(int[][] nums, int cols, int rows) {
        int start = 0;
        while (cols > start * 2 && rows > start * 2) {
            printMatrixInCircle(nums, cols, rows, start);
            ++start;
        }
    }

    private static void printMatrixInCircle(int[][] nums, int cols, int rows, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            System.out.printf("%d->", nums[start][i]);
        }
        //从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.printf("%d->", nums[i][endX]);
            }
        }
        //从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.printf("%d->", nums[endY][i]);
            }
        }
        //从下到上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                System.out.printf("%d->", nums[i][start]);
            }
        }
    }

    private static void print(int[][] nums, int cols, int rows) {
        for (int i = 0; i < rows; i++) {
            System.out.print("[");
            for (int j = 0; j < cols; j++) {
                if (j == cols - 1) {
                    System.out.printf("%d\t]", nums[i][j]);
                } else {
                    System.out.printf("%d\t", nums[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void test(int cols, int rows) {
        if (cols < 1 || rows < 1)
            return;
        int[][] nums = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nums[i][j] = i * cols + j + 1;
            }
        }
        print(nums, cols, rows);
        System.out.print("顺时针输出:");
        printMatrixClockwise(nums, cols, rows);
        System.out.println("\n===============");
    }
}

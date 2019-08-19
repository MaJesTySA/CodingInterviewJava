package q47_礼物的最大价值;

public class MaxValueOfGifts {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static int getMaxValue(int[] values, int rows, int cols) {
        if (values == null || rows <= 0 || cols <= 0) {
            return 0;
        }
        int[][] maxValues = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int up = 0;
                int left = 0;
                if (i > 0)
                    up = maxValues[i - 1][j];
                if (j > 0)
                    left = maxValues[i][j - 1];
                maxValues[i][j] = Math.max(up, left) + values[i * cols + j];
            }
        }
        return maxValues[rows - 1][cols - 1];
    }

    private static int getMaxValueLessSpace(int[] values, int rows, int cols) {
        if (values == null || rows <= 0 || cols <= 0) {
            return 0;
        }
        int[] maxValues = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0)
                    up = maxValues[j];
                if (j > 0)
                    left = maxValues[j - 1];
                maxValues[j] = Math.max(left, up) + values[i * cols + j];
            }
        }
        return maxValues[cols - 1];
    }

    private static void test(String name, int[] values, int rows, int cols, int expected) {
        System.out.println(name + ": ");
        System.out.print("Solution 1: ");
        if (getMaxValue(values, rows, cols) == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
        System.out.print("Solution 2: ");
        if (getMaxValueLessSpace(values, rows, cols) == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");

    }

    private static void test1() {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        test("Test1", values, 3, 3, 29);
    }

    private static void test2() {
        int[] values = {1, 10, 3, 8, 12, 2, 9, 6, 5, 7, 4, 11, 3, 7, 16, 5};
        test("Test2", values, 4, 4, 53);
    }

    private static void test3() {
        int[] values = {1, 10, 3, 8};
        test("Test3", values, 1, 4, 22);
    }

    private static void test4() {
        int[] values = {1, 12, 5, 3};
        test("Test4", values, 4, 1, 21);
    }

    private static void test5() {
        int[] values = {3};
        test("Test5", values, 1, 1, 3);
    }

    private static void test6() {
        int[] values = null;
        test("Test6", values, 0, 0, 0);
    }
}

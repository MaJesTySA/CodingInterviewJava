package q13_机器人运动范围;

public class RobotMove {
    public static void main(String[] args) {
        //多行多列
        test(5, 10, 10, 21);
        test(15, 20, 20, 359);
        //只有一行，达到部分方格
        test(10, 1, 100, 29);
        //只有一行，达到所有方格
        test(10, 1, 10, 10);
        //只有一列，达到部分方格
        test(15, 100, 1, 79);
        //只有一列，达到所有方格
        test(15, 10, 1, 10);
        //只有一行一列
        test(15, 1, 1, 1);
        test(0, 1, 1, 1);
        //任意一个都不进入
        test(-10, 10, 10, 0);
    }

    private static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0)
            return 0;
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row][col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row, col - 1, visited) +
                    movingCountCore(threshold, rows, cols, row + 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    //检查能否进入matrix[row][col]
    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        return (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold
                && !visited[row][col]);
    }

    private static void test(int threshold, int rows, int cols, int expected) {
        if (movingCount(threshold, rows, cols) == expected)
            System.out.println("Passed");
        else
            System.out.println("Failed");
    }
}

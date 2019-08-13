package q12_矩阵中的路径;

public class PathInMatrix {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
    }

    private static void test1() {
        char[][] matrix = new char[][]{{'A', 'B', 'T', 'G'}, {'C', 'F', 'C', 'S'}, {'J', 'D', 'E', 'H'}};
        String str = "BFCE";
        System.out.println("expected = true" + "  result = " + hasPath(matrix, str));
    }

    private static void test2() {
        char[][] matrix = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String str = "SEE";
        System.out.println("expected = true" + "  result = " + hasPath(matrix, str));
    }

    private static void test3() {
        char[][] matrix = new char[][]{{'A', 'B', 'T', 'G'}, {'C', 'F', 'C', 'S'}, {'J', 'D', 'E', 'H'}};
        String str = "ABFB";
        System.out.println("expected = false" + "  result = " + hasPath(matrix, str));
    }

    private static void test4() {
        char[][] matrix = new char[][]
                {{'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G'},
                        {'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q'},
                        {'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E'},
                        {'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M'},
                        {'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'}};
        String str = "SLHECCEIDEJFGGFIE";
        System.out.println("expected = true" + "  result = " + hasPath(matrix, str));
    }

    private static void test5() {
        char[][] matrix = new char[][]
                {{'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G'},
                        {'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q'},
                        {'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E'},
                        {'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M'},
                        {'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'}};
        String str = "SGGFIECVAASABCEHJIGQEM";
        System.out.println("expected = true" + "  result = " + hasPath(matrix, str));
    }

    private static void test6() {
        char[][] matrix = new char[][]
                {{'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G'},
                        {'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q'},
                        {'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E'},
                        {'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M'},
                        {'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'}};
        String str = "SGGFIECVAASABCEEJIGOEM";
        System.out.println("expected = false" + "  result = " + hasPath(matrix, str));
    }

    private static void test7() {
        char[][] matrix = new char[][]
                {{'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G'},
                        {'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q'},
                        {'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E'},
                        {'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M'},
                        {'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'}};
        String str = "SGGFIECVAASABCEHJIGQEMS";
        System.out.println("expected = false" + "  result = " + hasPath(matrix, str));
    }

    private static void test8() {
        char[][] matrix = new char[][]
                {{'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}};
        String str = "AAAAAAAAAAAA";
        System.out.println("expected = true" + "  result = " + hasPath(matrix, str));
    }

    private static void test9() {
        char[][] matrix = new char[][]
                {{'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}};
        String str = "AAAAAAAAAAAAA";
        System.out.println("expected = false" + "  result = " + hasPath(matrix, str));
    }

    private static void test10() {
        char[][] matrix = new char[][]{{'A'}};
        String str = "A";
        System.out.println("expected = true" + "  result = " + hasPath(matrix, str));
    }

    private static void test11() {
        char[][] matrix = new char[][]{{'A'}};
        String str = "B";
        System.out.println("expected = false" + "  result = " + hasPath(matrix, str));
    }

    private static void test12() {
        char[][] matrix = null;
        String str = null;
        System.out.println("expected = false" + "  result = " + hasPath(matrix, str));
    }

    private static boolean hasPath(char[][] matrix, String str) {
        if (matrix == null || matrix.length <= 0 || str == null || str.length() == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[][] matrix, int row, int col, String str, int pathLength, boolean[][] visieted) {
        if (pathLength == str.length())
            return true;
        boolean hasPath = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row][col] == str.charAt(pathLength)
                && !visieted[row][col]) {
            ++pathLength;
            visieted[row][col] = true;

            hasPath = hasPathCore(matrix, row, col - 1, str, pathLength, visieted) ||
                    hasPathCore(matrix, row - 1, col, str, pathLength, visieted) ||
                    hasPathCore(matrix, row, col + 1, str, pathLength, visieted) ||
                    hasPathCore(matrix, row + 1, col, str, pathLength, visieted);
            if (!hasPath) {
                --pathLength;
                visieted[row][col] = false;
            }

        }
        return hasPath;
    }
}

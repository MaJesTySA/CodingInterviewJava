package q04_二维数组查找元素;

public class FindIn2DArray {
    private static int[][] arr = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static boolean find(int[][] arr, int target) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        int row = 0;
        int column = arr.length - 1;
        while (row < arr.length && column >= 0) {
            if (arr[row][column] == target) {
                return true;
            } else if (arr[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    private static void test(String name, int[][] arr, int target, boolean expected) {
        System.out.print(name + ": ");
        boolean result = find(arr, target);
        if (result == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed");
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    private static void test1() {
        test("Test1", arr, 7, true);
    }

    //不在数组里
    private static void test2() {
        test("Test2", arr, 5, false);
    }

    //查找的数是最小的数
    private static void test3() {
        test("Test3", arr, 1, true);
    }

    //查找的数是最大的数
    private static void test4() {
        test("Test4", arr, 15, true);
    }

    //查找的数比最小数还小
    private static void test5() {
        test("Test5", arr, 0, false);
    }

    //查找的数比最大数还大
    private static void test6() {
        test("Test5", arr, 16, false);
    }

    //空数组
    private static void test7() {
        test("Test6", null, 16, false);
    }
}


package q42_连续子数组的最大和;

public class GreatestSumOfSubArrays {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static int findGreatestSubArr(int[] arr) {
        if (arr == null || arr.length <= 0)
            return 0;
        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (curSum <= 0)
                curSum = arr[i];
            else
                curSum += arr[i];
            if (curSum > greatestSum)
                greatestSum = curSum;
        }
        return greatestSum;
    }

    private static void test(String name, int[] arr, int expected) {
        System.out.print(name + ":");
        if (findGreatestSubArr(arr) == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed");
    }

    private static void test1() {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        test("Test1", arr, 18);
    }

    private static void test2() {
        int[] arr = {-2, -8, -1, -5, -9};
        test("Test2", arr, -1);
    }

    private static void test3() {
        int[] arr = {2, 8, 1, 5, 9};
        test("Test3", arr, 25);
    }

    private static void test4() {
        int[] arr = null;
        test("Test4", arr, 0);
    }
}

package q53_03_数值和下标相等的元素;

public class IntegerEqualsIndex {
    public static void main(String[] args) {
        test("Test1", new int[]{-3, -1, 1, 3, 5}, 3);
        test("Test2", new int[]{0, 1, 3, 5, 6}, 0);
        test("Test3", new int[]{-1, 0, 1, 2, 4}, 4);
        test("Test4", new int[]{-1, 0, 1, 2, 5}, -1);
        test("Test5", new int[]{0}, 0);
        test("Test6", new int[]{10}, -1);
        test("Test7", null, -1);
    }

    private static int getNumberSameAsIndex(int[] numbers) {
        if (numbers == null || numbers.length <= 0)
            return -1;
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == numbers[mid])
                return mid;
            if (numbers[mid] > mid)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    private static void test(String name, int[] numbers, int expected) {
        System.out.print(name + ": ");
        if (getNumberSameAsIndex(numbers) == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }
}

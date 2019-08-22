package q53_02_0至n减1中缺失的数;

public class MissingNumber {
    public static void main(String[] args) {
        test("Test1", new int[]{1, 2, 3, 4, 5}, 0);
        test("Test2", new int[]{0, 1, 2, 3, 4}, 5);
        test("Test3", new int[]{0, 1, 2, 4, 5}, 3);
        test("Test4", new int[]{1}, 0);
        test("Test5", new int[]{0}, 1);
        test("Test6", null, -1);
    }

    private static int getMissingNumber(int[] numbers) {
        if (numbers == null || numbers.length <= 0)
            return -1;
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //如果中间值不等于中间下标，两种情况
            if (numbers[mid] != mid) {
                //前面一个值等于其下标，或者Mid=0，那么mid就是缺失值
                if (mid == 0 || numbers[mid - 1] == mid - 1)
                    return mid;
                //否则就去前面找
                right = mid - 1;
                //如果中间值等于中间下标，就说明前面不缺失，去后面查找
            } else
                left = mid + 1;
        }
        if (left == numbers.length)
            return numbers.length;
        return -1;
    }

    private static void test(String name, int[] data, int expected) {
        System.out.print(name + ": ");
        if (getMissingNumber(data) == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }
}

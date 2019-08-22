package q53_01_排序数组中查找出现次数;

public class NumberOfK {
    public static void main(String[] args) {
        test("Test1", new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 8, 3, 4);
        test("Test2", new int[]{3, 3, 3, 3, 4, 5}, 6, 3, 4);
        test("Test3", new int[]{1, 2, 3, 3, 3, 3}, 6, 3, 4);
        test("Test4", new int[]{1, 3, 3, 3, 3, 4, 5}, 7, 2, 0);
        test("Test5", new int[]{1, 3, 3, 3, 3, 4, 5}, 7, 0, 0);
        test("Test6", new int[]{1, 3, 3, 3, 3, 4, 5}, 7, 6, 0);
        test("Test7", new int[]{3, 3, 3, 3}, 4, 3, 4);
        test("Test8", new int[]{3, 3, 3, 3}, 4, 4, 0);
        test("Test9", new int[]{3}, 1, 3, 1);
        test("Test10", new int[]{3}, 1, 4, 0);
        test("Test11", null, 0, 0, 0);
    }

    private static int getNumberOfK(int[] data, int length, int k) {
        int number = 0;
        if (data != null && length > 0) {
            int first = getFirstK(data, length, k, 0, length - 1);
            int last = getLastK(data, length, k, 0, length - 1);
            if (first > -1 && last > -1)
                number = last - first + 1;
        }
        return number;
    }

    //返回第一个K的下标
    private static int getFirstK(int[] data, int length, int k, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        int midValue = data[mid];
        if (midValue == k) {
            //前面不为k，或者k在0的位置，那么就是第一个k
            if (mid > 0 && data[mid - 1] != k || mid == 0)
                return mid;
            else
                //否则第一个k在前半段
                end = mid - 1;
        } else if (midValue > k)
            end = mid - 1;
        else
            start = mid + 1;
        return getFirstK(data, length, k, start, end);
    }

    //返回最后一个K的下标
    private static int getLastK(int[] data, int length, int k, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        int midValue = data[mid];
        if (midValue == k) {
            if (mid < length - 1 && data[mid + 1] != k || mid == length - 1)
                return mid;
            else
                start = mid + 1;
        } else if (midValue < k) {
            start = mid + 1;
        } else
            end = mid - 1;
        return getLastK(data, length, k, start, end);
    }

    private static void test(String name, int[] data, int length, int k, int expected) {
        System.out.print(name + ": ");
        if (getNumberOfK(data, length, k) == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }

}

package q40_最小的k个数;

import q39_出现次数超过一半的数.MoreThanHalfNumber;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class KLeastNumbers {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static int[] getLeastKthNumbers(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0 || k > nums.length)
            return null;
        int start = 0;
        int end = nums.length - 1;
        int index = MoreThanHalfNumber.partition(nums, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                index = MoreThanHalfNumber.partition(nums, start, index - 1);
            } else {
                index = MoreThanHalfNumber.partition(nums, index + 1, end);
            }
        }
        return Arrays.copyOfRange(nums, 0, k);
    }

    private static Set<Integer> getLeastKthNumbersNoEdit(int[] nums, int k) {
        Set<Integer> result = new TreeSet<>();
        if (nums == null || nums.length <= 0 || k <= 0 || k > nums.length)
            return null;
        for (int i = 0; i < nums.length; i++) {
            if (result.size() < k)
                result.add(nums[i]);
            else {
                if (nums[i] < ((TreeSet<Integer>) result).last()) {
                    result.remove(((TreeSet<Integer>) result).last());
                    result.add(nums[i]);
                }
            }
        }
        return result;
    }

    private static void print(int[] data, int k) {
        System.out.print("非修改原数组：" + Arrays.toString(data) + "  最小" + k + "个数：");
        try {
            System.out.println(Arrays.toString(getLeastKthNumbersNoEdit(data, k).toArray()));
        } catch (NullPointerException e) {
            System.out.println("null");
        }
        System.out.println("分治法原数组：" + Arrays.toString(data) + "  最小" + k + "个数：" + Arrays.toString(getLeastKthNumbers(data, k)));
        System.out.println("=======================");
    }

    // k小于数组的长度
    private static void test1() {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};
        print(data, 4);
    }

    // k等于数组的长度
    private static void test2() {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};
        print(data, 8);
    }

    // k大于数组的长度
    private static void test3() {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};
        print(data, 10);
    }

    // k等于0
    private static void test4() {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};
        print(data, 0);
    }

    // 有相同数组
    private static void test5() {
        int[] data = {4, 5, 1, 6, 2, 7, 2, 8};
        print(data, 2);
    }

    // 空数组
    private static void test6() {
        int[] data = {};
        print(data, 1);
    }
}

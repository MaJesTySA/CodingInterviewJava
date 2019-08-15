package q39_出现次数超过一半的数;

import java.util.Arrays;

public class MoreThanHalfNumber {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static int moreThanHalfNum(int[] nums) {
        if (checkInvalidArr(nums))
            return 0;
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (nums[i] == result) {
                times++;
            } else
                times--;
        }
        if (checkMoreThanHalf(nums, result))
            return 0;
        return result;
    }

    private static int moreThanHalfNumWithPartition(int[] nums) {
        if (checkInvalidArr(nums))
            return 0;
        int middle = nums.length >> 2;
        int left = 0;
        int right = nums.length - 1;
        int index = partition(nums, left, right);
        while (index != middle) {
            //index比middle大，在左边找
            if (index > middle) {
                index = partition(nums, left, index - 1);
            } else {
                index = partition(nums, index + 1, right);
            }
        }
        int result = nums[middle];
        if (checkMoreThanHalf(nums, result))
            return 0;
        return result;
    }


    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    private static boolean checkInvalidArr(int[] nums) {
        return nums == null || nums.length <= 0;
    }

    private static boolean checkMoreThanHalf(int[] nums, int num) {
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num)
                times++;
        }
        return times * 2 <= nums.length;
    }

    private static void print(int[] nums1, int[] nums2) {
        System.out.println("数组：" + Arrays.toString(nums1) + "  分治法结果：" + moreThanHalfNumWithPartition(nums1));
        System.out.println("数组：" + Arrays.toString(nums2) + "  计数法结果：" + moreThanHalfNum(nums2));
        System.out.println("==================");
    }

    private static void test1() {
        int[] nums1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] nums2 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        print(nums1, nums2);
    }

    private static void test2() {
        int[] nums1 = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        int[] nums2 = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        print(nums1, nums2);
    }

    private static void test3() {
        int[] nums1 = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        int[] nums2 = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        print(nums1, nums2);
    }

    private static void test4() {
        int[] nums1 = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        int[] nums2 = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        print(nums1, nums2);
    }

    private static void test5() {
        int[] nums1 = {1};
        int[] nums2 = {1};
        print(nums1, nums2);
    }

    private static void test6() {
        int[] nums1 = {};
        int[] nums2 = {};
        print(nums1, nums2);
    }
}

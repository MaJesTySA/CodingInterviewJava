package q21_调整数组顺序奇在偶前;

import java.util.Arrays;

public class ReorderArray {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void reorderOddEven(int[] arr) {
        if (arr.length == 0 || arr == null)
            return;
        int start = 0;
        int end = arr.length - 1;
        /*
        奇数要放在前面，所以start指针就一直向后找偶数，找到就停下，准备交换。
        end指针就一直向前找奇数，找到就停下，准备交换。
         */
        while (end > start) {
            //向后移动start，直到它指向偶数   奇数二进制最后一定为1，跟0x1与，为1。
            while (end > start && (arr[start] & 0x1) != 0)
                start++;
            //向前移动end，直到它指向奇数   偶数二进制最后一定为0，跟0x1与，为0。
            while (end > start && (arr[end] & 0x1) == 0)
                end--;
            if (end > start) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
    }

    private static void generalReorderOddEven(int[] arr) {
        if (arr.length == 0 || arr == null)
            return;
        int start = 0;
        int end = arr.length - 1;
        while (end > start) {
            while (end > start && !isEven(arr[start]))
                start++;
            while (end > start && isEven(arr[end]))
                end--;
            if (end > start) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
    }

    private static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    private static void printReordered(int[] numbers) {
        generalReorderOddEven(numbers);
        System.out.println("重排后的数组：" + Arrays.toString(numbers));
    }

    private static void test6() {
        int[] numbers = {};
        System.out.print("原数组：" + Arrays.toString(numbers) + " ");
        printReordered(numbers);
    }

    private static void test5() {
        int[] numbers = {2};
        System.out.print("原数组：" + Arrays.toString(numbers) + " ");
        printReordered(numbers);
    }

    private static void test4() {
        int[] numbers = {1};
        System.out.print("原数组：" + Arrays.toString(numbers) + " ");
        printReordered(numbers);
    }

    private static void test3() {
        int[] numbers = {1, 3, 5, 7, 2, 4, 6};
        System.out.print("原数组：" + Arrays.toString(numbers) + " ");
        printReordered(numbers);
    }

    private static void test2() {
        int[] numbers = {2, 4, 6, 1, 3, 5, 7};
        System.out.print("原数组：" + Arrays.toString(numbers) + " ");
        printReordered(numbers);
    }

    private static void test1() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("原数组：" + Arrays.toString(numbers) + " ");
        printReordered(numbers);
    }

}

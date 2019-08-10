package q3_数组重复数字;

import java.util.*;

public class DuplicationInArray {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void test6() {
        System.out.print("空数组：\t");
        System.out.println("expected = [] , result = " + getDuplicateWithHash(null));
    }

    private static void test5() {
        System.out.print("数组中没有重复的数字：\t");
        int[] arr = {2, 1, 3, 5, 4};
        System.out.println("expected = [] , result = " + getDuplicateWithHash(arr));
    }

    private static void test4() {
        System.out.print("数组中没有重复的数字：\t");
        int[] arr = {2, 1, 3, 0, 4};
        System.out.println("expected = [] , result = " + getDuplicateWithHash(arr));
    }

    private static void test3() {
        System.out.print("数组中存在多个重复的数字：\t");
        int[] arr = {2, 4, 2, 1, 4};
        System.out.println("expected = [2, 4] , result = " + getDuplicateWithHash(arr));
    }

    private static void test2() {
        System.out.print("重复的数字是数组中最大的数字：\t");
        int[] arr = {2, 4, 3, 1, 4};
        System.out.println("expected = [4] , result = " + getDuplicateWithHash(arr));
    }

    private static void test1() {
        System.out.print("重复的数字是数组中最小的数字：\t");
        int[] arr = {2, 1, 3, 1, 4};
        System.out.println("expected = [1] , result = " + getDuplicateWithHash(arr));
    }

    /*
        空间复杂度 HashMpa O(N)，时间复杂度O(N)。
     */
    private static Set<Integer> getDuplicateWithHash(int[] arr) {
        Set<Integer> result = new HashSet<>();
        if (arr == null || arr.length < 0) {
            return result;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1)
                return result;
        }
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (numsMap.get(arr[i]) == null) {
                numsMap.put(arr[i], arr[i]);
            } else
                result.add(arr[i]);
        }
        return result;
    }

    /*
        空间复杂度O(1)，虽然有两重循环，但是时间复杂度是O(N)。
     */
    private static Set<Integer> getDuplicateWithLessSpace(int[] arr) {
        Set<Integer> result = new HashSet<>();
        if (arr == null || arr.length < 0) {
            return result;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1)
                return result;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    result.add(arr[i]);
                } else {
                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
                }
            }
        }
        return result;
    }
}

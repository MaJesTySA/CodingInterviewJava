package q33_BST的后序遍历序列;

import java.util.Arrays;

public class SequenceOfBST {
    public static void main(String[] args) {
        test("Test1", new int[]{4, 8, 6, 12, 16, 14, 10}, true);
        test("Test2", new int[]{4, 6, 7, 5}, true);
        test("Test3", new int[]{1, 2, 3, 4, 5}, true);
        test("Test4", new int[]{5, 4, 3, 2, 1}, true);
        test("Test5", new int[]{5}, true);
        test("Test6", new int[]{7, 4, 6, 5}, false);
        test("Test7", new int[]{4, 6, 12, 8, 16, 14, 10}, false);
        test("Test8", new int[]{}, false);
    }

    private static boolean verifySeqOfBST(int[] seq, int length) {
        if (seq == null || length <= 0)
            return false;
        int root = seq[length - 1];
        int i = 0;
        for (; i < length - 1; i++) {
            if (seq[i] > root)
                break;
        }
        int j = i;
        for (; j < length - 1; j++) {
            if (seq[j] < root)
                return false;
        }
        boolean left = true;
        if (i > 0)
            left = verifySeqOfBST(seq, i);
        boolean right = true;
        if (i < length - 1) {
            int[] temp = Arrays.copyOfRange(seq, i, length - 1);
            right = verifySeqOfBST(temp, length - i - 1);
        }
        return left && right;
    }

    //不用Arrays.copyOfRange
    private static boolean verifySeqOfBST(int[] seq, int start, int end) {
        if (seq == null || end + 1 - start <= 0)
            return false;
        int root = seq[end];
        int i = start;
        for (; i < end; i++) {
            if (seq[i] > root)
                break;
        }
        int j = i;
        for (; j < end; j++) {
            if (seq[j] < root)
                return false;
        }
        boolean left = true;
        if (i > start)
            left = verifySeqOfBST(seq, start, i - 1);
        boolean right = true;
        if (i < end)
            right = verifySeqOfBST(seq, i, end - 1);
        return left && right;
    }

    private static void test(String name, int[] arr, boolean expected) {
        System.out.print(name + ": ");
        boolean result = verifySeqOfBST(arr, 0, arr.length - 1);
        if (expected == result)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }
}

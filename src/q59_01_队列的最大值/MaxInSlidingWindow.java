package q59_01_队列的最大值;

import java.util.*;

public class MaxInSlidingWindow {
    public static void main(String[] args) {
        test("Test1", new int[]{2, 3, 4, 2, 6, 2, 5, 1}, new Integer[]{4, 4, 6, 6, 6, 5}, 3);
        test("Test2", new int[]{1, 3, -1, -3, 5, 3, 6, 7}, new Integer[]{3, 3, 5, 5, 6, 7}, 3);
        test("Test3", new int[]{1, 3, 5, 7, 9, 11, 13, 15}, new Integer[]{7, 9, 11, 13, 15}, 4);
        test("Test4", new int[]{16, 14, 12, 10, 8, 6, 4}, new Integer[]{16, 14, 12}, 5);
        test("Test5", new int[]{10, 14, 12, 11}, new Integer[]{10, 14, 12, 11}, 1);
        test("Test6", new int[]{10, 14, 12, 11}, new Integer[]{14}, 4);
        test("Test7", new int[]{10, 14, 12, 11}, new Integer[]{}, 0);
        test("Test8", new int[]{10, 14, 12, 11}, new Integer[]{}, 5);
        test("Test9", new int[]{}, new Integer[]{}, 5);
    }

    private static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> maxInWindows = new ArrayList<>();
        if (num.length >= size && size >= 1) {
            LinkedList<Integer> queue = new LinkedList<>();
            //添加前3个数
            for (int i = 0; i < size; i++) {
                while (!queue.isEmpty() && num[i] >= num[queue.peekLast()])
                    queue.removeLast();
                queue.addLast(i);
            }
            for (int i = size; i < num.length; i++) {
                //当队首元素就是最大值，添加
                maxInWindows.add(num[queue.peekFirst()]);
                //新来的值比队尾的大，删除队尾
                while (!queue.isEmpty() && num[i] >= num[queue.peekLast()])
                    queue.removeLast();
                //添加之前先判断一下，窗口大小
                if (!queue.isEmpty() && queue.peekFirst() <= i - size)
                    queue.removeFirst();
                queue.addLast(i);
            }
            maxInWindows.add(num[queue.peekFirst()]);
        }
        return maxInWindows;
    }

    private static void test(String name, int[] num, Integer[] expected, int size) {
        System.out.print(name + ": ");
        if (Arrays.equals(maxInWindows(num, size).toArray(), expected))
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }

}

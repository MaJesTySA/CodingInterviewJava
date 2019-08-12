package q31_栈的压入弹出序列;

import java.util.Stack;

public class StackPushPopOrder {
    public static void main(String[] args) {
        test("Test1", new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}, 5, true);
        test("Test2", new int[]{1, 2, 3, 4, 5}, new int[]{3, 5, 4, 2, 1}, 5, true);
        test("Test3", new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}, 5, false);
        test("Test4", new int[]{1, 2, 3, 4, 5}, new int[]{3, 5, 4, 1, 2}, 5, false);
        test("Test5", new int[]{1}, new int[]{2}, 1, false);
        test("Test5", new int[]{1}, new int[]{1}, 1, true);
        test("Test6", null, null, 0, false);
    }

    private static boolean isPopOrder(int[] push, int[] pop, int length) {
        boolean possible = false;
        if (push != null && pop != null && length > 0) {
            int nextPush = 0;
            int nextPop = 0;
            Stack<Integer> stack = new Stack<>();
            while (nextPop < length) {
                while (stack.isEmpty() || stack.peek() != pop[nextPop]) {
                    //没找到
                    if (nextPush == length)
                        break;
                    stack.push(push[nextPush]);
                    nextPush++;
                }
                if (stack.peek() != pop[nextPop])
                    break;
                stack.pop();
                nextPop++;
            }
            if (stack.isEmpty() && nextPop == length)
                possible = true;
        }
        return possible;
    }

    private static void test(String name, int[] push, int[] pop, int length, boolean expected) {
        if (name != null)
            System.out.print(name + ": ");
        if (isPopOrder(push, pop, length) == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }
}

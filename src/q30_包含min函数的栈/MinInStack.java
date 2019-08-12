package q30_包含min函数的栈;

import java.util.Stack;

public class MinInStack {

    private static Stack<Integer> dataStack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        push(3);
        test("Test1", 3);
        push(4);
        test("Test2", 3);
        push(2);
        test("Test3", 2);
        push(3);
        test("Test4", 2);
        pop();
        test("Test5", 2);
        pop();
        test("Test6", 3);
        pop();
        test("Test7", 3);
        push(0);
        test("Test8", 0);
    }

    private static void push(int data) {
        dataStack.push(data);
        if (minStack.size() == 0 || data < minStack.peek())
            minStack.push(data);
        else
            minStack.push(minStack.peek());
    }

    private static void pop() {
        if (dataStack.size() > 0 && minStack.size() > 0) {
            dataStack.pop();
            minStack.pop();
        }
    }

    private static Integer min() {
        if (dataStack.size() > 0 && minStack.size() > 0)
            return minStack.peek();
        return null;
    }

    private static void test(String name, int expected) {
        System.out.print(name + ": ");
        if (min() == null) {
            System.out.println("栈已空");
            return;
        }
        if (min() == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }
}

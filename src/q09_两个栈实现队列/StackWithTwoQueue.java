package q09_两个栈实现队列;

import java.util.LinkedList;

public class StackWithTwoQueue {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.print("abc入栈：");
        stack.showStack();
        System.out.print("\n" + stack.pop() + "出栈：");
        stack.showStack();
        stack.push("d");
        System.out.print("\nd入栈：");
        stack.showStack();
        System.out.print("\n" + stack.pop() + "出栈：");
        stack.showStack();
        stack.push("e");
        System.out.print("\ne入栈：");
        stack.showStack();
        System.out.print("\n" + stack.pop() + "出栈：");
        stack.showStack();
        System.out.print("\n" + stack.pop() + "出栈：");
        stack.showStack();
        System.out.print("\n" + stack.pop() + "出栈：");
        stack.showStack();
    }
}

class Stack<T> {
    private LinkedList<T> queue1 = new LinkedList<>();
    private LinkedList<T> queue2 = new LinkedList<>();

    public void push(T node) {
        queue1.addLast(node);
    }

    public T pop() {
        if (queue1.size() + queue2.size() > 0) {
            if (!queue1.isEmpty()) {
                while (queue1.size() > 1)
                    queue2.addLast(queue1.removeFirst());
                return queue1.removeFirst();
            } else {
                while (queue2.size() > 1)
                    queue1.addLast(queue2.removeFirst());
                return queue2.removeFirst();
            }
        } else {
            System.out.println("空栈");
            return null;
        }
    }

    public void showStack() {
        if (queue1.size()==0 && queue2.size()==0){
            System.out.println("栈已空");
        }
        if (queue1.size() > 0 && queue2.size() == 0) {
            for (T ele : queue1) {
                System.out.print(ele + "<-");
            }
            return;
        }
        if (queue2.size() > 0 && queue1.size() == 0) {
            for (T ele : queue2) {
                System.out.print(ele + "<-");
            }
            return;
        }
        if (queue1.size() > 0 && queue2.size() > 0) {
            for (T ele : queue2) {
                System.out.print(ele + "<-");
            }
            for (T ele : queue1) {
                System.out.print(ele + "<-");
            }
        }
    }
}

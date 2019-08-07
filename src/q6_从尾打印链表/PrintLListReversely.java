package q6_从尾打印链表;

import java.util.Stack;

public class PrintLListReversely {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(12);
        ListNode node4 = new ListNode(19);
        ListNode node5 = new ListNode(22);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.print("栈方式测试多个节点  : ");
        printWithStack(node1);
        System.out.print("递归方式测试多个节点: ");
        printWithRecur(node1);
        System.out.println("HEAD");
    }

    private static void test2() {
        ListNode node1 = new ListNode(5);
        System.out.print("栈方式测试一个节点:  ");
        printWithStack(node1);
        System.out.print("递归方式测试多个节点:");
        printWithRecur(node1);
        System.out.println("HEAD");
    }

    private static void test3() {
        System.out.print("栈方式测试空链表:  ");
        printWithStack(null);
        System.out.print("递归方式测试空链表:");
        printWithRecur(null);
    }

    private static void printWithStack(ListNode head) {
        if (head == null) {
            System.out.println("空链表");
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode curNode = head;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().value + "->");
        }
        System.out.println("HEAD");
    }

    private static void printWithRecur(ListNode head) {
        if (head == null) {
            System.out.println("空链表");
            return;
        }
        if (head.next != null) {
            printWithRecur(head.next);
        }
        System.out.print(head.value + "->");
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}

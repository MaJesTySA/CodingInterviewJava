package q52_两个链表的第一个公共节点;

import utils.ListNode;

import java.util.Stack;

public class FirstCommonNodesInLists {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static int getLength(ListNode head) {
        int length = 0;
        ListNode curNode = head;
        while (curNode != null) {
            ++length;
            curNode = curNode.next;
        }
        return length;
    }

    private static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        int length1 = getLength(head1);
        int length2 = getLength(head2);
        int difLength = Math.abs(length1 - length2);
        ListNode longHead = head1;
        ListNode shortHead = head2;
        if (length1 < length2) {
            longHead = head2;
            shortHead = head1;
        }
        for (int i = 0; i < difLength; i++) {
            longHead = longHead.next;
        }
        boolean flag = true;
        while (longHead != null && shortHead != null && longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;
    }

    private static ListNode findFirstCommonNodeWithStack(ListNode head1, ListNode head2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode curNode = head1;
        while (curNode != null) {
            stack1.push(curNode);
            curNode = curNode.next;
        }
        curNode = head2;
        while (curNode != null) {
            stack2.push(curNode);
            curNode = curNode.next;
        }
        ListNode tempNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty() &&
                stack1.peek() == stack2.peek()) {
            tempNode = stack1.pop();
            stack2.pop();
        }
        return tempNode;
    }

    // 第一个公共结点在链表中间
    // 1 - 2 - 3 \
    //            6 - 7
    //     4 - 5 /
    private static void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node6.next = node7;
        node4.next = node5;
        node5.next = node6;
        System.out.println("expected value : 6 , result : " + findFirstCommonNode(node1, node4).value
                + " ,stack method result : " + findFirstCommonNodeWithStack(node1, node4).value);
    }

    // 没有公共结点
    // 1 - 2 - 3 - 4
    //
    // 5 - 6 - 7
    private static void test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node5.next = node6;
        node6.next = node7;
        System.out.println("expected value : null , result : " + findFirstCommonNode(node1, node5)
                + " ,stack method result : " + findFirstCommonNodeWithStack(node1, node5));
    }

    // 公共结点是最后一个结点
    // 1 - 2 - 3 - 4 \
    //                7
    //         5 - 6 /
    private static void test3() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node7;
        node5.next = node6;
        node6.next = node7;
        System.out.println("expected value : 7 , result : " + findFirstCommonNode(node1, node5).value
                + " ,stack method result : " + findFirstCommonNodeWithStack(node1, node5).value);
    }

    // 公共结点是第一个结点
    // 1 - 2 - 3 - 4 - 5
    // 两个链表完全重合
    private static void test4() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("expected value : 1 , result : " + findFirstCommonNode(node1, node1).value
                + " ,stack method result : " + findFirstCommonNodeWithStack(node1, node1).value);
    }

    // 输入的两个链表有一个空链表
    private static void test5() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("expected value : null , result : " + findFirstCommonNode(null, node1)
                + " ,stack method result : " + findFirstCommonNodeWithStack(null, node1));
    }

    // 输入的两个链表有一个空链表
    private static void test6() {
        System.out.println("expected value : null , result : " + findFirstCommonNode(null, null)
                + " ,stack method result : " + findFirstCommonNodeWithStack(null, null));
    }
}

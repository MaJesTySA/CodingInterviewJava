package q24_反转链表;

import utils.ListNode;

public class ReverseList {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static ListNode reverse(ListNode head) {
        ListNode reverseHead = null;
        ListNode curNode = head;
        ListNode preNode = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            if (nextNode == null)
                reverseHead = curNode;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return reverseHead;
    }

    private static void test3() {
        System.out.println("空链表");
        ListNode node1 = null;
        print(node1);
    }

    private static void test2() {
        System.out.println("输入链表只有一个节点");
        ListNode node1 = new ListNode(1);
        print(node1);
    }

    private static void test1() {
        System.out.println("输入链表有多个节点：");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        print(node1);
    }

    private static void print(ListNode node1) {
        System.out.print("反转前：");
        ListNode.print(node1);
        System.out.print("反转后：");
        ListNode.print(reverse(node1));
        System.out.println("=============");
    }
}

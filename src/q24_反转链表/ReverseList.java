package q24_反转链表;

import utils.ListNode;

public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        test1(head);
        System.out.println("=================");
        test2(head);
        System.out.println("=================");
        test3(head);
    }

    private static ListNode reverse(ListNode head) {
        ListNode reverseHead = null;
        ListNode curNode = head.next;
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

    private static void print(ListNode head) {
        if (head == null || head.next == null) {
            System.out.println("空链表");
            return;
        }
        ListNode curListNode = head.next;
        while (curListNode != null) {
            System.out.print(curListNode.value + "->");
            curListNode = curListNode.next;
        }
        System.out.println("NULL");
    }

    private static void test3(ListNode head) {
        System.out.println("空链表");
        head.next = null;
        System.out.print("反转前：");
        print(head);
        head.next = reverse(head);
        System.out.print("反转后：");
        print(head);
    }

    private static void test2(ListNode head) {
        System.out.println("输入链表只有一个节点");
        head.next = new ListNode(1);
        System.out.print("反转前：");
        print(head);
        head.next = reverse(head);
        System.out.print("反转后：");
        print(head);
    }

    private static void test1(ListNode head) {
        System.out.println("输入链表有多个节点：");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.print("反转前：");
        print(head);
        head.next = reverse(head);
        System.out.print("反转后：");
        print(head);
    }

}

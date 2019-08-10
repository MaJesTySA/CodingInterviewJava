package q23_链表中环的入口节点;

import utils.ListNode;

public class EntryNodeInListLoop {
    public static void main(String[] args) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        test1(head);
        test2(head);
        test3(head);
        test4(head);
        test5(head);
        test6(head);
        test7(head);
    }

    private static ListNode meetingNode(ListNode head) {
        if (head == null || head.next == null)
            return null;
        //一开始都从head出发，slow和fast相等，所以先走一步
        ListNode slow = head.next.next;
        if (slow == null)
            return null;
        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow)
                return fast;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return null;
    }

    private static ListNode entryNodeOfLoop(ListNode head) {
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null)
            return null;
        int loops = 1;
        ListNode node1 = meetingNode;
        while (node1.next != meetingNode) {
            node1 = node1.next;
            ++loops;
        }
        node1 = head.next;
        for (int i = 0; i < loops; i++) {
            node1 = node1.next;
        }
        ListNode node2 = head.next;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    private static void test7(ListNode head) {
        System.out.print("空链表             ：\t");
        System.out.println("expected = null , result = " + entryNodeOfLoop(head));
    }

    private static void test6(ListNode head) {
        System.out.print("链表有多个元素，无环：\t");
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
        System.out.println("expected = null , result = " + entryNodeOfLoop(head));
    }


    private static void test5(ListNode head) {
        System.out.print("链表有多个元素，有环：\t");
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
        node5.next = node5;
        System.out.println("expected = 5 , result = " + entryNodeOfLoop(head).value);
    }

    private static void test4(ListNode head) {
        System.out.print("链表有多个元素，有环：\t");
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
        node5.next = node1;
        System.out.println("expected = 1 , result = " + entryNodeOfLoop(head).value);
    }

    private static void test3(ListNode head) {
        System.out.print("链表有多个元素，有环：\t");
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
        node5.next = node3;
        System.out.println("expected = 3 , result = " + entryNodeOfLoop(head).value);
    }

    private static void test2(ListNode head) {
        System.out.print("链表只有一个元素，有环：\t");
        ListNode node1 = new ListNode(1);
        head.next = node1;
        node1.next = node1;
        System.out.println("expected = 1 , result = " + entryNodeOfLoop(head).value);
    }

    private static void test1(ListNode head) {
        System.out.print("链表只有一个元素，无环：\t");
        ListNode node1 = new ListNode(1);
        head.next = node1;
        System.out.println("expected = null , result = " + entryNodeOfLoop(head));
    }

}

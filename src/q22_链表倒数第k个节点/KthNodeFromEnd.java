package q22_链表倒数第k个节点;

import utils.ListNode;

public class KthNodeFromEnd {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k == 0)
            return null;
        ListNode ahead = head;
        ListNode behind = head;
        for (int i = 0; i < k - 1; i++) {
            //这个判断处理当链表数量<k的情况
            if (ahead.next != null)
                ahead = ahead.next;
            else
                return null;
        }
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }

    private static void test6() {
        System.out.print("测试第二个参数为0：expected = null , result = ");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(findKthToTail(node1, 0));
    }

    private static void test5() {
        System.out.print("测试大于节点总数：expected = null , result = ");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(findKthToTail(node1, 6));
    }

    private static void test4() {
        System.out.print("测试空链表：expected = null , result = ");
        System.out.println(findKthToTail(null, 100));
    }

    private static void test3() {
        System.out.print("测试的节点在开始：expected = 1 , result = ");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(findKthToTail(node1, 5).value);
    }

    private static void test2() {
        System.out.print("测试的节点在最后：expected = 5 , result = ");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(findKthToTail(node1, 1).value);
    }

    private static void test1() {
        System.out.print("测试的节点在中间：expected = 4 , result = ");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(findKthToTail(node1, 2).value);
    }
}


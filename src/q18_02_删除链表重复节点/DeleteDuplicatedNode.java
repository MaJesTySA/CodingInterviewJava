package q18_02_删除链表重复节点;

import utils.ListNode;

public class DeleteDuplicatedNode {
    public static void main(String[] args) {
        test1();
        System.out.println("=================");
        test2();
        System.out.println("=================");
        test3();
        System.out.println("=================");
        test4();
        System.out.println("=================");
        test5();
        System.out.println("=================");
        test6();
        System.out.println("=================");
        test7();
        System.out.println("=================");
        test8();
        System.out.println("=================");
        test9();
    }

    private static void test10() {
        System.out.println("空链表");
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode node1 = null;
        head.next = node1;
        print(head);
        delete(head);
        print(head);
    }

    private static void test9() {
        System.out.println("链表中只有两个重复的节点");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        linkAndPrint(node1, node2);
    }

    private static void test8() {
        System.out.println("链表中只有一个的节点");
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        print(head);
        delete(head);
        print(head);
    }

    private static void test7() {
        System.out.println("链表中只有两个不重复的节点");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        linkAndPrint(node1, node2);
    }

    private static void test6() {
        System.out.println("除了两个结点之外其他结点都成对出现");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(5);
        linkAndPrint(node1, node2, node3, node4, node5, node6, node7, node8);
    }

    private static void test5() {
        System.out.println("所有节点成对出现");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(4);
        linkAndPrint(node1, node2, node3, node4, node5, node6, node7, node8);
    }

    private static void test4() {
        System.out.println("所有节点都重复");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(1);
        linkAndPrint(node1, node2, node3, node4, node5, node6, node7);
    }

    private static void test3() {
        System.out.println("除了一个以外其它都重复");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(2);
        linkAndPrint(node1, node2, node3, node4, node5, node6, node7);
    }

    private static void test2() {
        System.out.println("没有重复的");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        linkAndPrint(node1, node2, node3, node4, node5, node6, node7);
    }

    private static void test1() {
        System.out.println("某些节点是重复的");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        linkAndPrint(node1, node2, node3, node4, node5, node6, node7);
    }

    private static void delete(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode preNode = head;
        ListNode curNode = head.next;
        while (curNode != null) {
            ListNode next = curNode.next;
            boolean needDelete = false;
            if (next != null && next.value == curNode.value)
                needDelete = true;
            if (!needDelete) {
                preNode = curNode;
                curNode = curNode.next;
            } else {
                ListNode toBeDel = curNode;
                while (toBeDel != null && toBeDel.value == curNode.value) {
                    toBeDel = toBeDel.next;
                }
                preNode.next = toBeDel;
                curNode = toBeDel;
            }
        }
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

    private static void linkAndPrint(ListNode node1, ListNode node2, ListNode node3, ListNode node4, ListNode node5, ListNode node6, ListNode node7) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        print(head);
        delete(head);
        print(head);
    }

    private static void linkAndPrint(ListNode node1, ListNode node2, ListNode node3, ListNode node4, ListNode node5, ListNode node6, ListNode node7, ListNode node8) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        print(head);
        delete(head);
        print(head);
    }

    private static void linkAndPrint(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = node1;
        node1.next = node2;
        print(head);
        delete(head);
        print(head);
    }
}



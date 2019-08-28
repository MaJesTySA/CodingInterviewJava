package q18_02_删除链表重复节点;

import utils.ListNode;

public class DeleteDuplicatedNode {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
    }

    private static ListNode deleteDup(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            boolean needDelete = false;
            if (nextNode != null && nextNode.value == curNode.value)
                needDelete = true;
            if (!needDelete) {
                preNode = curNode;
                curNode = curNode.next;
            } else {
                ListNode deleteNode = curNode;
                while (deleteNode != null && deleteNode.value == curNode.value) {
                    deleteNode = deleteNode.next;
                }
                if (preNode == null)
                    head = deleteNode;
                else
                    preNode.next = deleteNode;
                curNode = deleteNode;
            }
        }
        return head;
    }

    private static void test10() {
        System.out.println("空链表");
        ListNode node1 = null;
        ListNode.print(node1);
        ListNode.print(deleteDup(node1));
        System.out.println("=============");
    }

    private static void test9() {
        System.out.println("链表中只有两个重复的节点");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode.print(node1);
        ListNode.print(deleteDup(node1));
        System.out.println("=============");
    }

    private static void test8() {
        System.out.println("链表中只有一个的节点");
        ListNode node1 = new ListNode(1);
        ListNode.print(node1);
        ListNode.print(deleteDup(node1));
        System.out.println("=============");
    }

    private static void test7() {
        System.out.println("链表中只有两个不重复的节点");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode.print(node1);
        ListNode.print(deleteDup(node1));
        System.out.println("=============");
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode.print(node1);
        ListNode.print(deleteDup(node1));
        System.out.println("=============");
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode.print(node1);
        ListNode.print(deleteDup(node1));
        System.out.println("=============");
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode.print(node1);
        ListNode.print(deleteDup(node1));
        System.out.println("=============");
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode.print(node1);
        ListNode.print(deleteDup(node1));
        System.out.println("=============");
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode.print(node1);
        ListNode.print(deleteDup(node1));
        System.out.println("=============");
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode.print(node1);
        ListNode.print(deleteDup(node1));
        System.out.println("=============");
    }
}



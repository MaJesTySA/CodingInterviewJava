package q18_01_删除链表的节点;

import utils.ListNode;

public class DeleteNodeInList {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static ListNode delete(ListNode head, ListNode deleted) {
        if (head == null || deleted == null) {
            return null;
        }
        if (deleted.next != null) {
            //找到被删除节点的下一个节点
            ListNode next = deleted.next;
            //将下一个节点的内容，复制给被删除节点
            deleted.value = next.value;
            //由于被删除节点的Next指向了删除节点Next的Next，所以next成了垃圾，会被GC
            deleted.next = next.next;
        } else if (head == deleted) {
            head = null;
        } else {
            ListNode tmp = head;
            while (tmp.next != deleted) {
                tmp = tmp.next;
            }
            tmp.next = null;
        }
        return head;
    }

    private static void test1() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println("删除中间节点");
        ListNode.print(listNode1);
        ListNode head=delete(listNode1, listNode3);
        ListNode.print(head);
        System.out.println("==================");
    }

    private static void test2() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println("删除尾节点");
        ListNode.print(listNode1);
        ListNode head=delete(listNode1, listNode5);
        ListNode.print(head);
        System.out.println("==================");
    }

    private static void test3() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println("删除第一个节点");
        ListNode.print(listNode1);
        ListNode head=delete(listNode1, listNode1);
        ListNode.print(head);
        System.out.println("==================");
    }

    private static void test4() {
        ListNode listNode1 = new ListNode(1);
        System.out.println("只有一个节点");
        ListNode.print(listNode1);
        ListNode head=delete(listNode1, listNode1);
        ListNode.print(head);
        System.out.println("==================");
    }

    private static void test5() {
        ListNode listNode1 = null;
        ListNode.print(listNode1);
        System.out.println("删除空链表");
        ListNode head=delete(listNode1, listNode1);
        ListNode.print(head);
        System.out.println("==================");
    }
}


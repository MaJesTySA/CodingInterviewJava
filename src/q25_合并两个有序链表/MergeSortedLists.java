package q25_合并两个有序链表;

import utils.ListNode;

public class MergeSortedLists {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static ListNode merge(ListNode realHead1, ListNode realHead2) {
        if (realHead1 == null)
            return realHead2;
        else if (realHead2 == null)
            return realHead1;
        ListNode mergedHead;
        //链表1比链表2小，将链表1作为mergedHead，之后，将链表1的下一个节点，和链表2当前节点传入
        if (realHead1.value < realHead2.value) {
            mergedHead = realHead1;
            mergedHead.next = merge(realHead1.next, realHead2);
        } else {
            mergedHead = realHead2;
            mergedHead.next = merge(realHead1, realHead2.next);
        }
        return mergedHead;
    }

    private static void print(ListNode l1_node1, ListNode l2_node1) {
        System.out.print("链表1： ");
        ListNode.print(l1_node1);
        System.out.print("链表2： ");
        ListNode.print(l2_node1);
        System.out.print("合并后：");
        ListNode.print(merge(l1_node1, l2_node1));
        System.out.println("============");
    }

    private static void test5() {
        System.out.println("两个都为空");
        ListNode l1_node1 = null;
        ListNode l2_node1 = null;
        print(l1_node1, l2_node1);
    }

    private static void test4() {
        System.out.println("有一个链表为空");
        ListNode l1_node1 = new ListNode(1);
        ListNode l1_node2 = new ListNode(3);
        ListNode l1_node3 = new ListNode(5);
        l1_node1.next = l1_node2;
        l1_node2.next = l1_node3;
        ListNode l2_node1 = null;
        print(l1_node1, l2_node1);
    }

    private static void test3() {
        System.out.println("两个链表只有一个数字");
        ListNode l1_node1 = new ListNode(1);
        ListNode l2_node1 = new ListNode(2);
        print(l1_node1, l2_node1);
    }

    private static void test2() {
        System.out.println("合并有个无重复数字的链表");
        ListNode l1_node1 = new ListNode(1);
        ListNode l1_node2 = new ListNode(3);
        ListNode l1_node3 = new ListNode(5);
        l1_node1.next = l1_node2;
        l1_node2.next = l1_node3;
        ListNode l2_node1 = new ListNode(1);
        ListNode l2_node2 = new ListNode(3);
        ListNode l2_node3 = new ListNode(5);
        l2_node1.next = l2_node2;
        l2_node2.next = l2_node3;
        print(l1_node1, l2_node1);
    }

    private static void test1() {
        System.out.println("合并两个无重复数字的链表");
        ListNode l1_node1 = new ListNode(1);
        ListNode l1_node2 = new ListNode(3);
        ListNode l1_node3 = new ListNode(5);
        l1_node1.next = l1_node2;
        l1_node2.next = l1_node3;
        ListNode l2_node1 = new ListNode(2);
        ListNode l2_node2 = new ListNode(4);
        ListNode l2_node3 = new ListNode(6);
        l2_node1.next = l2_node2;
        l2_node2.next = l2_node3;
        print(l1_node1, l2_node1);
    }
}

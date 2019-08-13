package utils;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public static void print(ListNode head) {
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
}

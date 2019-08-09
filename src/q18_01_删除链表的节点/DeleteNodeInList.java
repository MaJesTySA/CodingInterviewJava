package q18_01_删除链表的节点;

import utils.ListNode;

public class DeleteNodeInList {
    public static void main(String[] args) {
        //删除中间节点
        test1();
        System.out.println("==================");
        //删除尾节点
        test2();
        System.out.println("==================");
        //删除头节点
        test3();
        System.out.println("==================");
        //只有一个节点
        test4();
        System.out.println("==================");
        //空链表
        test5();
    }

    private static void test1() {
        ListNode head=new ListNode(Integer.MIN_VALUE);
        ListNode listNode1 =new ListNode(1);
        ListNode listNode2 =new ListNode(2);
        ListNode listNode3 =new ListNode(3);
        ListNode listNode4 =new ListNode(4);
        ListNode listNode5 =new ListNode(5);
        head.next=listNode1;
        listNode1.next= listNode2;
        listNode2.next= listNode3;
        listNode3.next= listNode4;
        listNode4.next= listNode5;
        System.out.println("删除中间节点");
        print(head);
        delete(head, listNode3);
        print(head);
    }

    private static void test2(){
        ListNode head=new ListNode(Integer.MIN_VALUE);
        ListNode listNode1 =new ListNode(1);
        ListNode listNode2 =new ListNode(2);
        ListNode listNode3 =new ListNode(3);
        ListNode listNode4 =new ListNode(4);
        ListNode listNode5 =new ListNode(5);
        head.next=listNode1;
        listNode1.next= listNode2;
        listNode2.next= listNode3;
        listNode3.next= listNode4;
        listNode4.next= listNode5;
        System.out.println("删除尾节点");
        print(head);
        delete(head, listNode5);
        print(head);
    }

    private static void test3(){
        ListNode head=new ListNode(Integer.MIN_VALUE);
        ListNode listNode1 =new ListNode(1);
        ListNode listNode2 =new ListNode(2);
        ListNode listNode3 =new ListNode(3);
        ListNode listNode4 =new ListNode(4);
        ListNode listNode5 =new ListNode(5);
        head.next=listNode1;
        listNode1.next= listNode2;
        listNode2.next= listNode3;
        listNode3.next= listNode4;
        listNode4.next= listNode5;
        System.out.println("删除第一个节点");
        print(head);
        delete(head, listNode1);
        print(head);
    }

    private static void test4(){
        ListNode head=new ListNode(Integer.MIN_VALUE);
        ListNode listNode1 =new ListNode(1);
        head.next=listNode1;
        System.out.println("只有一个节点");
        print(head);
        delete(head, listNode1);
        print(head);
    }
    
    private static void test5(){
        ListNode head=new ListNode(Integer.MIN_VALUE);
        ListNode listNode1 =null;
        head.next=listNode1;
        print(head);
        System.out.println("删除空链表");
        delete(head, listNode1);
        print(head);
    }
    

    private static void delete(ListNode head, ListNode deleted) {
        if (head==null || head.next==null||deleted ==null){
            return;
        }
        if (deleted.next != null) {
            //找到被删除节点的下一个节点
            ListNode next = deleted.next;
            //将下一个节点的内容，复制给被删除节点
            deleted.value = next.value;
            //由于被删除节点的Next指向了删除节点Next的Next，所以next成了垃圾，会被GC
            deleted.next = next.next;
        } else if (head.next == deleted) {
            head.next=null;
        } else {
            ListNode tmp = head.next;
            while (tmp.next != deleted) {
                tmp = tmp.next;
            }
            tmp.next = null;
        }
    }

    private static void print(ListNode head){
        if (head==null || head.next==null){
            System.out.println("空链表");
            return;
        }
        ListNode curListNode = head.next;
        while (curListNode !=null){
            System.out.print(curListNode.value+"->");
            curListNode = curListNode.next;
        }
        System.out.println("NULL");
    }
}


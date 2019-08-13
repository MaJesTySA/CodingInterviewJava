package q35_复杂链表的复制;

public class CopyComplexList {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static ComplexList clone(ComplexList head) {
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

    private static void cloneNodes(ComplexList head) {
        ComplexList curNode = head;
        while (curNode != null) {
            ComplexList cloneNode = new ComplexList(curNode.value);
            //复制节点的下一个节点指向当前节点的下一节点
            cloneNode.next = curNode.next;
            cloneNode.sibling = null;
            //当前节点的下一节点指向复制节点
            curNode.next = cloneNode;
            //将当前节点设置为其之前的下一个节点
            curNode = cloneNode.next;
        }
    }

    private static void connectSiblingNodes(ComplexList head) {
        ComplexList curNode = head;
        while (curNode != null) {
            //取出当前链表的下一个节点，即复制的节点
            ComplexList cloneNode = curNode.next;
            if (curNode.sibling != null) {
                //那么复制节点的sibling节点，就是当前节点silbing节点的下一个节点
                cloneNode.sibling = curNode.sibling.next;
            }
            curNode = cloneNode.next;
        }
    }

    private static ComplexList reconnectNodes(ComplexList head) {
        ComplexList curNode = head;
        ComplexList cloneHead = null;
        ComplexList cloneNode = null;
        if (curNode != null) {
            cloneHead = cloneNode = curNode.next;
            curNode.next = cloneNode.next;
            curNode = curNode.next;
        }
        while (curNode != null) {
            cloneNode.next = curNode.next;
            cloneNode = cloneNode.next;
            curNode.next = cloneNode.next;
            curNode = curNode.next;
        }
        return cloneHead;
    }

    private static void test(String name, ComplexList head) {
        System.out.println("=============" + name + "============");
        System.out.println("原链表");
        ComplexList.print(head);
        System.out.println("复制链表");
        ComplexList.print(clone(head));
    }

    //          -----------------
    //         \|/              |
    //  1-------2-------3-------4-------5
    //  |       |      /|\             /|\
    //  --------+--------               |
    //          -------------------------
    private static void test1() {
        ComplexList node1 = new ComplexList(1);
        ComplexList node2 = new ComplexList(2);
        ComplexList node3 = new ComplexList(3);
        ComplexList node4 = new ComplexList(4);
        ComplexList node5 = new ComplexList(5);
        ComplexList.buildNodes(node1, node2, node3);
        ComplexList.buildNodes(node2, node3, node5);
        ComplexList.buildNodes(node3, node4, null);
        ComplexList.buildNodes(node4, node5, node2);
        test("Test1", node1);
    }

    // 指向结点自身
    //          -----------------
    //         \|/              |
    //  1-------2-------3-------4-------5
    //         |       | /|\           /|\
    //         |       | --             |
    //         |------------------------|
    private static void test2() {
        ComplexList node1 = new ComplexList(1);
        ComplexList node2 = new ComplexList(2);
        ComplexList node3 = new ComplexList(3);
        ComplexList node4 = new ComplexList(4);
        ComplexList node5 = new ComplexList(5);
        ComplexList.buildNodes(node1, node2, null);
        ComplexList.buildNodes(node2, node3, node5);
        ComplexList.buildNodes(node3, node4, node3);
        ComplexList.buildNodes(node4, node5, node2);
        test("Test2", node1);
    }

    // 形成环
    //          -----------------
    //         \|/              |
    //  1-------2-------3-------4-------5
    //          |              /|\
    //          |               |
    //          |---------------|
    private static void test3() {
        ComplexList node1 = new ComplexList(1);
        ComplexList node2 = new ComplexList(2);
        ComplexList node3 = new ComplexList(3);
        ComplexList node4 = new ComplexList(4);
        ComplexList node5 = new ComplexList(5);
        ComplexList.buildNodes(node1, node2, null);
        ComplexList.buildNodes(node2, node3, node4);
        ComplexList.buildNodes(node3, node4, null);
        ComplexList.buildNodes(node4, node5, node2);
        test("Test3", node1);
    }

    private static void test4() {
        ComplexList node1 = new ComplexList(1);
        test("Test4", node1);
    }

    private static void test5() {
        ComplexList node1 = null;
        test("Test5", node1);
    }


}

class ComplexList {
    int value;
    ComplexList next;
    ComplexList sibling;

    public ComplexList(int value) {
        this.value = value;
    }

    public static void buildNodes(ComplexList root, ComplexList next, ComplexList sibling) {
        if (root != null) {
            root.next = next;
            root.sibling = sibling;
        }
    }

    public static void print(ComplexList head) {
        ComplexList curNode = head;
        while (curNode != null) {
            System.out.print("value : " + curNode.value);
            if (curNode.sibling != null)
                System.out.print(" , sibling value : " + curNode.sibling.value);
            else
                System.out.print(" , no sibling node");
            System.out.println();
            curNode = curNode.next;
        }
    }
}

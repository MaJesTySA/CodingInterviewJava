package q54_BST第K大节点;

import utils.BinaryTreeNode;

public class KthNodeInBST {
    private static int k;

    public static void main(String[] args) {
        testA();
        testB();
        testC();
        testD();
        testE();
    }

    private static BinaryTreeNode kthNode(BinaryTreeNode root) {
        if (root == null || k == 0)
            return null;
        return kthNodeCore(root);
    }

    private static BinaryTreeNode kthNodeCore(BinaryTreeNode root) {
        BinaryTreeNode target = null;
        //先去左边找
        if (root.left != null)
            target = kthNodeCore(root.left);
        //没找到
        if (target == null) {
            //k==1，找到了
            if (k == 1)
                target = root;
            k--;
        }
        //再去右边找
        if (target == null && root.right != null)
            target = kthNodeCore(root.right);
        return target;
    }

    private static void test(String name, BinaryTreeNode root, int kth, boolean isNull, int expected) {
        k = kth;
        System.out.print(name + ": ");
        BinaryTreeNode target = kthNode(root);
        if ((isNull && target == null) || (!isNull && target.value == expected))
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }

    //            8
    //        6      10
    //       5 7    9  11
    private static void testA() {
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(10);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        BinaryTreeNode node7 = new BinaryTreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        test("TestA1", node1, 0, true, -1);
        test("TestA2", node1, 1, false, 5);
        test("TestA3", node1, 2, false, 6);
        test("TestA4", node1, 3, false, 7);
        test("TestA5", node1, 4, false, 8);
        test("TestA6", node1, 5, false, 9);
        test("TestA7", node1, 6, false, 10);
        test("TestA8", node1, 7, false, 11);
        test("TestA9", node1, 8, true, -1);
        System.out.println("=============");
    }

    //            5
    //          4
    //        3
    //      2
    //    1
    private static void testB() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(1);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        test("TestB1", node1, 0, true, -1);
        test("TestB2", node1, 1, false, 1);
        test("TestB3", node1, 2, false, 2);
        test("TestB4", node1, 3, false, 3);
        test("TestB5", node1, 4, false, 4);
        test("TestB6", node1, 5, false, 5);
        test("TestB7", node1, 6, true, -1);
        System.out.println("=============");
    }

    //        1
    //         2
    //          3
    //           4
    //            5
    private static void testC() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        test("TestC1", node1, 0, true, -1);
        test("TestC2", node1, 1, false, 1);
        test("TestC3", node1, 2, false, 2);
        test("TestC4", node1, 3, false, 3);
        test("TestC5", node1, 4, false, 4);
        test("TestC6", node1, 5, false, 5);
        test("TestC7", node1, 6, true, -1);
        System.out.println("=============");
    }

    private static void testD() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        test("TestD1", node1, 0, true, -1);
        test("TestD2", node1, 1, false, 1);
        test("TestD3", node1, 2, true, -1);
        System.out.println("=============");
    }

    private static void testE() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        test("TestE1", null, 0, true, -1);
        test("TestE2", null, 1, true, -1);
        System.out.println("=============");
    }
}

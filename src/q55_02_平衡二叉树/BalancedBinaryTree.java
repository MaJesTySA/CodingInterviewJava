package q55_02_平衡二叉树;

import q55_01_树的深度.TreeDepth;
import utils.BinaryTreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

    private static boolean isBalanced(BinaryTreeNode root) {
        if (root == null)
            return true;
        int left = TreeDepth.treeDepth(root.left);
        int right = TreeDepth.treeDepth(root.right);
        if (Math.abs(left - right) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static void test(String name, BinaryTreeNode node, boolean expected) {
        System.out.print(name + ": ");
        if (isBalanced(node) == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed");
    }

    //            8
    //        6      10
    //       5 7    9  11
    private static void test1() {
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
        test("Test1", node1, true);
    }

    //             1
    //         /      \
    //        2        3
    //       /\         \
    //      4  5         6
    //        /
    //       7
    private static void test2() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node7;
        node3.right = node6;
        test("Test2", node1, true);
    }

    // 不是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\
    //      4  5
    //        /
    //       6
    private static void test3() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        test("Test3", node1, false);
    }

    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test4() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(1);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        test("Test4", node1, false);
    }

    private static void test5() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        test("Test5", node1, false);
    }

    private static void test6() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        test("Test6", node1, true);
    }

    private static void test7() {
        test("Test7", null, true);
    }

}

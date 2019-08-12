package q27_二叉树镜像;

import utils.BinaryTreeNode;

public class MirrorOfBinaryTree {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void print(BinaryTreeNode node1) {
        if (node1 == null) {
            System.out.println("空树！");
            return;
        }
        System.out.print("变换之前：");
        node1.preOrder();
        System.out.print("\n变换之后：");
        mirrorRecursively(node1);
        node1.preOrder();
        System.out.println("\n=============");
    }

    private static void mirrorRecursively(BinaryTreeNode node) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            return;
        BinaryTreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
        if (node.left != null)
            mirrorRecursively(node.left);
        if (node.right != null)
            mirrorRecursively(node.right);
    }

    //            8
    //        6      10
    //       5 7    9  11
    private static void test1() {
        System.out.println("测试完全二叉树");
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
        print(node1);
    }

    //            8
    //          7
    //        6
    //      5
    //    4
    private static void test2() {
        System.out.println("测试全左节点");
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(7);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        print(node1);
    }

    //            8
    //             7
    //              6
    //               5
    //                4
    private static void test3() {
        System.out.println("测试全右节点");
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(7);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        print(node1);
    }

    //测试空树
    private static void test4() {
        BinaryTreeNode node1 = null;
        System.out.println("测试空树");
        System.out.print("变换之前：");
        print(node1);
        System.out.print("变换之后：");
        mirrorRecursively(node1);
        print(node1);
        System.out.println("=============");
    }

    //测试只有一个节点
    private static void test5() {
        System.out.println("测试只有一个节点");
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        print(node1);
    }
}

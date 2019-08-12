package q28_对称的二叉树;

import utils.BinaryTreeNode;

public class SymmetricalBinaryTree {
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

    private static boolean isSymmetrical(BinaryTreeNode node) {
        return isSymmetrical(node, node);
    }

    private static boolean isSymmetrical(BinaryTreeNode node1, BinaryTreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.value != node2.value)
            return false;
        return isSymmetrical(node1.left, node2.right) &&
                isSymmetrical(node1.right, node2.left);
    }

    //            8
    //        6      6
    //       5 7    7 5
    private static void test1() {
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(7);
        BinaryTreeNode node7 = new BinaryTreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println("expected = true , result = " + isSymmetrical(node1));
    }

    //            8
    //        6      9
    //       5 7    7 5
    private static void test2() {
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(9);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(7);
        BinaryTreeNode node7 = new BinaryTreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println("expected = false , result = " + isSymmetrical(node1));
    }

    //            8
    //        6      6
    //       5 7    7
    private static void test3() {
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        System.out.println("expected = false , result = " + isSymmetrical(node1));
    }

    //               5
    //              / \
    //             3   3
    //            /     \
    //           4       4
    //          /         \
    //         2           2
    //        /             \
    //       1               1
    private static void test4() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(2);
        BinaryTreeNode node7 = new BinaryTreeNode(2);
        BinaryTreeNode node8 = new BinaryTreeNode(1);
        BinaryTreeNode node9 = new BinaryTreeNode(1);
        node1.left = node2;
        node2.left = node4;
        node4.left = node6;
        node6.left = node8;
        node1.right = node3;
        node3.right = node5;
        node5.right = node7;
        node7.right = node9;
        System.out.println("expected = true , result = " + isSymmetrical(node1));
    }

    //               5
    //              / \
    //             3   3
    //            /     \
    //           4       4
    //          /         \
    //         6           2
    //        /             \
    //       1               1
    private static void test5() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(2);
        BinaryTreeNode node8 = new BinaryTreeNode(1);
        BinaryTreeNode node9 = new BinaryTreeNode(1);
        node1.left = node2;
        node2.left = node4;
        node4.left = node6;
        node6.left = node8;
        node1.right = node3;
        node3.right = node5;
        node5.right = node7;
        node7.right = node9;
        System.out.println("expected = false , result = " + isSymmetrical(node1));
    }

    //               5
    //              / \
    //             3   3
    //            /     \
    //           4       4
    //          /         \
    //         2           2
    //                      \
    //                       1
    private static void test6() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(2);
        BinaryTreeNode node8 = new BinaryTreeNode(1);
        node1.left = node2;
        node2.left = node4;
        node4.left = node6;
        node6.left = node8;
        node1.right = node3;
        node3.right = node5;
        node5.right = node7;
        node7.right = node8;
        System.out.println("expected = false , result = " + isSymmetrical(node1));
    }

    //只有一个节点
    private static void test7() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        System.out.println("expected = true , result = " + isSymmetrical(node1));
    }

    //空
    private static void test8() {
        BinaryTreeNode node1 = null;
        System.out.println("expected = true , result = " + isSymmetrical(node1));
    }

    //               5
    //              / \
    //             5   5
    //            /     \
    //           5       5
    //          /         \
    //         5           5
    private static void test9() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(5);
        BinaryTreeNode node7 = new BinaryTreeNode(5);
        node1.left = node2;
        node2.left = node4;
        node4.left = node6;
        node1.right = node3;
        node3.right = node5;
        node5.right = node7;
        System.out.println("expected = true , result = " + isSymmetrical(node1));
    }

    //               5
    //              / \
    //             5   5
    //            /     \
    //           5       5
    //          /       /
    //         5       5
    private static void test10() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(5);
        BinaryTreeNode node7 = new BinaryTreeNode(5);
        node1.left = node2;
        node2.left = node4;
        node4.left = node6;
        node1.right = node3;
        node3.right = node5;
        node5.left = node7;
        System.out.println("expected = false , result = " + isSymmetrical(node1));
    }


}

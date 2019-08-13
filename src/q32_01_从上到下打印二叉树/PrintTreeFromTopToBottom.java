package q32_01_从上到下打印二叉树;

import utils.BinaryTreeNode;

import java.util.LinkedList;


public class PrintTreeFromTopToBottom {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void printFromTopToBottom(BinaryTreeNode root) {
        if (root == null)
            return;
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode curNode = queue.removeFirst();
            System.out.printf("%d ", curNode.value);
            if (curNode.left != null)
                queue.add(curNode.left);
            if (curNode.right != null)
                queue.add(curNode.right);
        }
    }

//            10
//         /      \
//        6        14
//       /\        /\
//      4  8     12  16
    private static void test1() {
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(14);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(12);
        BinaryTreeNode node7 = new BinaryTreeNode(16);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        printFromTopToBottom(node1);
        System.out.println("\n=============");
    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    private static void test2() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(1);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        printFromTopToBottom(node1);
        System.out.println("\n=============");
    }

    // 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
    private static void test3() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        printFromTopToBottom(node1);
        System.out.println("\n=============");
    }

    //只有一个节点
    private static void test4() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        printFromTopToBottom(node1);
        System.out.println("\n=============");
    }

    //空树
    private static void test5() {
        BinaryTreeNode node1 = null;
        printFromTopToBottom(node1);
        System.out.println("\n=============");
    }
}

package q32_03_之字形打印;

import utils.BinaryTreeNode;
import java.util.Stack;

public class PrintTreesInZigzag {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void printInZigzag(BinaryTreeNode root) {
        if (root == null)
            return;
        Stack<BinaryTreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack();
        stacks[1] = new Stack();
        int current = 0;
        int next = 1;
        stacks[current].push(root);
        while (!stacks[0].isEmpty() || !stacks[1].isEmpty()) {
            BinaryTreeNode curNode = stacks[current].pop();
            System.out.printf("%d ", curNode.value);
            if (current == 0) {
                if (curNode.left != null)
                    stacks[next].push(curNode.left);
                if (curNode.right != null)
                    stacks[next].push(curNode.right);
            } else {
                if (curNode.right != null)
                    stacks[next].push(curNode.right);
                if (curNode.left != null)
                    stacks[next].push(curNode.left);
            }
            if (stacks[current].isEmpty()) {
                System.out.println();
                current = 1 - current;
                next = 1 - next;
            }
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
        printInZigzag(node1);
        System.out.println("=============");
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
        printInZigzag(node1);
        System.out.println("=============");
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
        printInZigzag(node1);
        System.out.println("=============");
    }

    //        100
    //        /
    //       50
    //         \
    //         150
    private static void test4() {
        BinaryTreeNode node1 = new BinaryTreeNode(100);
        BinaryTreeNode node2 = new BinaryTreeNode(50);
        BinaryTreeNode node3 = new BinaryTreeNode(150);
        node1.left = node2;
        node2.right = node3;
        printInZigzag(node1);
        System.out.println("=============");
    }

    private static void test5() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        printInZigzag(node1);
        System.out.println("=============");
    }

    private static void test6() {
        BinaryTreeNode node1 = null;
        printInZigzag(node1);
        System.out.println("=============");
    }
}

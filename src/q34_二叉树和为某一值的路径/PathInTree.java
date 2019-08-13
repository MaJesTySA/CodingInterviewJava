package q34_二叉树和为某一值的路径;

import utils.BinaryTreeNode;

import java.util.ArrayList;


public class PathInTree {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void findPath(BinaryTreeNode root, int expectedSum) {
        if (root == null)
            return;
        ArrayList<Integer> path = new ArrayList<>();
        int curSum = 0;
        findPath(root, expectedSum, path, curSum);
    }

    private static void findPath(BinaryTreeNode root, int expectedSum, ArrayList<Integer> path, int curSum) {
        curSum += root.value;
        path.add(root.value);
        //如果当前节点是叶子节点，且和为输入值
        boolean isLeaf = root.left == null && root.right == null;
        if (curSum == expectedSum && isLeaf) {
            System.out.print("一条路径已找到: ");
            for (Integer value : path) {
                System.out.printf("%d\t", value);
            }
            System.out.println();
        }
        //如果不是叶子节点，遍历子节点
        if (root.left != null)
            findPath(root.left, expectedSum, path, curSum);
        if (root.right != null)
            findPath(root.right, expectedSum, path, curSum);
        //！！！在返回父节点之前，路径上删除当前节点
        path.remove(Integer.valueOf(root.value));
    }

    //            10
    //         /      \
    //        5        12
    //       /\
    //      4  7
    // 有两条路径上的结点和为22，没有路径和为15。
    private static void test1() {
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println("Test1: 和为22的路径：");
        findPath(node1, 22);
        System.out.println("==========");
        System.out.println("Test2: 和为15的路径：");
        findPath(node1, 15);
        System.out.println("==========");
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
        System.out.println("Test3: 和为15的路径：");
        findPath(node1, 15);
        System.out.println("==========");
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
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(1);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        System.out.println("Test4: 和为16的路径：");
        findPath(node1, 16);
        System.out.println("==========");
    }

    private static void test4() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        System.out.println("Test5: 只有一个节点：");
        findPath(node1, 5);
        System.out.println("==========");
    }

    private static void test5() {
        System.out.println("Test6: 空树：");
        findPath(null, 5);
        System.out.println("==========");
    }
}

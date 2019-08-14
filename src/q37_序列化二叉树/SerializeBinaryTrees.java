package q37_序列化二叉树;

import utils.BinaryTreeNode;

public class SerializeBinaryTrees {
    private static int pos = 0;

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();

    }

    private static String serialize(BinaryTreeNode root, String treeStr) {
        if (root == null)
            return "$,";
        return (root.value) + "," + serialize(root.left, treeStr) + serialize(root.right, treeStr);
    }

    private static BinaryTreeNode deserialize(String[] treeString) {
        String str = treeString[pos];
        if (str.equals("$"))
            return null;
        else {
            BinaryTreeNode node = new BinaryTreeNode(Integer.valueOf(str));
            pos++;
            node.left = deserialize(treeString);
            pos++;
            node.right = deserialize(treeString);
            return node;
        }
    }

    private static void print(BinaryTreeNode node1) {
        pos = 0;
        String treeStr = serialize(node1, "");
        System.out.println("序列化结果：" + treeStr);
        BinaryTreeNode node = deserialize(treeStr.split(","));
        System.out.print("反序列化前序遍历：");
        node.preOrder();
        System.out.println("\n================");
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
        print(node1);
    }

    //            5
    //          4
    //        3
    //      2
    private static void test2() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        print(node1);
    }

    //        5
    //         4
    //          3
    //           2
    private static void test3() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        print(node1);
    }

    private static void test4() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        print(node1);
    }

    //        5
    //         5
    //          5
    //         5
    //        5
    //       5 5
    //      5   5
    private static void test5() {
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(5);
        BinaryTreeNode node7 = new BinaryTreeNode(5);
        BinaryTreeNode node8 = new BinaryTreeNode(5);
        BinaryTreeNode node9 = new BinaryTreeNode(5);
        node1.right = node2;
        node2.right = node3;
        node3.left = node4;
        node4.left = node5;
        node5.left = node6;
        node5.right = node7;
        node6.left = node8;
        node7.right = node9;
        print(node1);
    }
}



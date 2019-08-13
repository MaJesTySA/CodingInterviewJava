package q08_二叉树的下一个节点;


import utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetNextNode {
    public static void main(String[] args) {
        test1();
        System.out.println("======");
        test2();
        System.out.println("======");
        test3();
    }

    private static void test1() {
        System.out.println("完全二叉树");
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(10);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        BinaryTreeNode node7 = new BinaryTreeNode(11);
        node1.right = node2;
        node1.right = node3;
        node2.parent = node1;
        node2.right = node4;
        node2.right = node5;
        node3.parent = node1;
        node3.right = node6;
        node3.right = node7;
        node4.parent = node2;
        node5.parent = node2;
        node6.parent = node3;
        node7.parent = node3;
        List<BinaryTreeNode> lists = new ArrayList<>();
        lists.add(node1);
        lists.add(node2);
        lists.add(node3);
        lists.add(node4);
        lists.add(node5);
        lists.add(node6);
        lists.add(node7);
        System.out.print("中序遍历: ");
        node1.inOrder();
        System.out.println();
        printNodes(lists);
    }

    private static void test2() {
        System.out.println("只有左节点");
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        node1.right = node2;
        node2.right = node3;
        node2.parent = node1;
        node3.right = node4;
        node3.parent = node2;
        node4.parent = node3;
        List<BinaryTreeNode> lists = new ArrayList<>();
        lists.add(node1);
        lists.add(node2);
        lists.add(node3);
        lists.add(node4);
        System.out.print("中序遍历: ");
        node1.inOrder();
        System.out.println();
        printNodes(lists);
    }

    private static void printNodes(List<BinaryTreeNode> lists) {
        for (int i = 0; i < lists.size(); i++) {
            try {
                System.out.println("节点: " + lists.get(i).value + "的后继结点: " + getNextNode(lists.get(i)).value);
            } catch (Exception e) {
                System.out.println("节点: " + lists.get(i).value + "的后继结点: null");
            }
        }
    }

    private static void test3() {
        System.out.println("只有右节点");
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        node1.right = node2;
        node2.parent = node1;
        node2.right = node3;
        node3.parent = node2;
        node3.right = node4;
        node4.parent = node3;
        List<BinaryTreeNode> lists = new ArrayList<>();
        lists.add(node1);
        lists.add(node2);
        lists.add(node3);
        lists.add(node4);
        System.out.print("中序遍历: ");
        node1.inOrder();
        System.out.println();
        printNodes(lists);
    }

    private static BinaryTreeNode getNextNode(BinaryTreeNode node) {
        if (node == null)
            return null;
        BinaryTreeNode nextNode = null;
        //如果该节点右节点不为空，则找右节点的最左节点
        if (node.right != null) {
            BinaryTreeNode tempNode = node.right;
            while (tempNode.right != null) {
                tempNode = tempNode.right;
            }
            nextNode = tempNode;
        }
        //如果该节点右节点为空，则看该节点是否是父节点的左节点
        else if (node.parent != null) {
            BinaryTreeNode curNode = node;
            BinaryTreeNode pareNode = node.parent;
            while (pareNode != null && curNode == pareNode.right) {
                curNode = pareNode;
                pareNode = pareNode.parent;
            }
            nextNode = pareNode;
        }
        return nextNode;
    }
}



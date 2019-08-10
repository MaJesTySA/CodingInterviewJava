package q26_树的子结构;

import utils.BinaryTreeNode;

public class SubstructureInTree {
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
    }

    private static boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.value == root2.value)
                result = doseTree1HaveTree2(root1, root2);
            if (!result)
                result = hasSubtree(root1.left, root2);
            if (!result)
                result = hasSubtree(root1.right, root2);
        }
        return result;
    }

    private static boolean doseTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.value != root2.value)
            return false;
        return doseTree1HaveTree2(root1.left, root2.left) && doseTree1HaveTree2(root1.right, root2.right);
    }

    private static void test9() {
        System.out.print("都为空树：\t");
        System.out.println("expected = false , result = " + hasSubtree(null, null));
    }

    private static void test8() {
        System.out.print("B为空树：\t");
        BinaryTreeNode aNode1 = new BinaryTreeNode(8);
        BinaryTreeNode aNode2 = new BinaryTreeNode(8);
        BinaryTreeNode aNode3 = new BinaryTreeNode(9);
        BinaryTreeNode aNode4 = new BinaryTreeNode(2);
        BinaryTreeNode aNode5 = new BinaryTreeNode(5);
        aNode1.right = aNode2;
        aNode2.right = aNode3;
        aNode3.right = aNode4;
        aNode4.right = aNode5;
        System.out.println("expected = false , result = " + hasSubtree(aNode1, null));
    }

    private static void test7() {
        System.out.print("A为空树：\t");
        BinaryTreeNode bNode1 = new BinaryTreeNode(8);
        BinaryTreeNode bNode2 = new BinaryTreeNode(9);
        BinaryTreeNode bNode3 = new BinaryTreeNode(3);
        BinaryTreeNode bNode4 = new BinaryTreeNode(2);
        bNode1.right = bNode2;
        bNode2.left = bNode3;
        bNode2.right = bNode4;
        System.out.println("expected = false , result = " + hasSubtree(null, bNode1));
    }

    private static void test6() {
        System.out.print("只有右子结点，树B不是树A的子结构：\t");
        BinaryTreeNode aNode1 = new BinaryTreeNode(8);
        BinaryTreeNode aNode2 = new BinaryTreeNode(8);
        BinaryTreeNode aNode3 = new BinaryTreeNode(9);
        BinaryTreeNode aNode4 = new BinaryTreeNode(2);
        BinaryTreeNode aNode5 = new BinaryTreeNode(5);
        aNode1.right = aNode2;
        aNode2.right = aNode3;
        aNode3.right = aNode4;
        aNode4.right = aNode5;
        BinaryTreeNode bNode1 = new BinaryTreeNode(8);
        BinaryTreeNode bNode2 = new BinaryTreeNode(9);
        BinaryTreeNode bNode3 = new BinaryTreeNode(3);
        BinaryTreeNode bNode4 = new BinaryTreeNode(2);
        bNode1.right = bNode2;
        bNode2.left = bNode3;
        bNode2.right = bNode4;
        System.out.println("expected = false , result = " + hasSubtree(aNode1, bNode1));
    }

    private static void test5() {
        System.out.print("只有右子结点，树B是树A的子结构：\t");
        BinaryTreeNode aNode1 = new BinaryTreeNode(8);
        BinaryTreeNode aNode2 = new BinaryTreeNode(8);
        BinaryTreeNode aNode3 = new BinaryTreeNode(9);
        BinaryTreeNode aNode4 = new BinaryTreeNode(2);
        BinaryTreeNode aNode5 = new BinaryTreeNode(5);
        aNode1.right = aNode2;
        aNode2.right = aNode3;
        aNode3.right = aNode4;
        aNode4.right = aNode5;
        BinaryTreeNode bNode1 = new BinaryTreeNode(8);
        BinaryTreeNode bNode2 = new BinaryTreeNode(9);
        BinaryTreeNode bNode3 = new BinaryTreeNode(2);
        bNode1.right = bNode2;
        bNode2.right = bNode3;
        System.out.println("expected = true , result = " + hasSubtree(aNode1, bNode1));
    }

    private static void test4() {
        System.out.print("只有左子结点，树B不是树A的子结构：\t");
        BinaryTreeNode aNode1 = new BinaryTreeNode(8);
        BinaryTreeNode aNode2 = new BinaryTreeNode(8);
        BinaryTreeNode aNode3 = new BinaryTreeNode(9);
        BinaryTreeNode aNode4 = new BinaryTreeNode(2);
        BinaryTreeNode aNode5 = new BinaryTreeNode(5);
        aNode1.left = aNode2;
        aNode2.left = aNode3;
        aNode3.left = aNode4;
        aNode4.left = aNode5;
        BinaryTreeNode bNode1 = new BinaryTreeNode(8);
        BinaryTreeNode bNode2 = new BinaryTreeNode(9);
        BinaryTreeNode bNode3 = new BinaryTreeNode(3);
        bNode1.left = bNode2;
        bNode2.left = bNode3;
        System.out.println("expected = false , result = " + hasSubtree(aNode1, bNode1));
    }

    private static void test3() {
        System.out.print("只有左子结点，树B是树A的子结构：\t");
        BinaryTreeNode aNode1 = new BinaryTreeNode(8);
        BinaryTreeNode aNode2 = new BinaryTreeNode(8);
        BinaryTreeNode aNode3 = new BinaryTreeNode(9);
        BinaryTreeNode aNode4 = new BinaryTreeNode(2);
        BinaryTreeNode aNode5 = new BinaryTreeNode(5);
        aNode1.left = aNode2;
        aNode2.left = aNode3;
        aNode3.left = aNode4;
        aNode4.left = aNode5;
        BinaryTreeNode bNode1 = new BinaryTreeNode(8);
        BinaryTreeNode bNode2 = new BinaryTreeNode(9);
        BinaryTreeNode bNode3 = new BinaryTreeNode(2);
        bNode1.left = bNode2;
        bNode2.left = bNode3;
        System.out.println("expected = true , result = " + hasSubtree(aNode1, bNode1));
    }

    private static void test2() {
        System.out.print("树B不是树A的子结构：\t\t");
        BinaryTreeNode aNode1 = new BinaryTreeNode(8);
        BinaryTreeNode aNode2 = new BinaryTreeNode(8);
        BinaryTreeNode aNode3 = new BinaryTreeNode(7);
        BinaryTreeNode aNode4 = new BinaryTreeNode(9);
        BinaryTreeNode aNode5 = new BinaryTreeNode(3);
        BinaryTreeNode aNode6 = new BinaryTreeNode(4);
        BinaryTreeNode aNode7 = new BinaryTreeNode(7);
        aNode1.left = aNode2;
        aNode1.right = aNode3;
        aNode2.left = aNode4;
        aNode2.right = aNode5;
        aNode5.left = aNode6;
        aNode5.right = aNode7;
        BinaryTreeNode bNode1 = new BinaryTreeNode(8);
        BinaryTreeNode bNode2 = new BinaryTreeNode(9);
        BinaryTreeNode bNode3 = new BinaryTreeNode(2);
        bNode1.left = bNode2;
        bNode1.right = bNode3;
        System.out.println("expected = false , result = " + hasSubtree(aNode1, bNode1));
    }

    private static void test1() {
        System.out.print("树B是树A的子结构：\t\t");
        BinaryTreeNode aNode1 = new BinaryTreeNode(8);
        BinaryTreeNode aNode2 = new BinaryTreeNode(8);
        BinaryTreeNode aNode3 = new BinaryTreeNode(7);
        BinaryTreeNode aNode4 = new BinaryTreeNode(9);
        BinaryTreeNode aNode5 = new BinaryTreeNode(2);
        BinaryTreeNode aNode6 = new BinaryTreeNode(4);
        BinaryTreeNode aNode7 = new BinaryTreeNode(7);
        aNode1.left = aNode2;
        aNode1.right = aNode3;
        aNode2.left = aNode4;
        aNode2.right = aNode5;
        aNode5.left = aNode6;
        aNode5.right = aNode7;
        BinaryTreeNode bNode1 = new BinaryTreeNode(8);
        BinaryTreeNode bNode2 = new BinaryTreeNode(9);
        BinaryTreeNode bNode3 = new BinaryTreeNode(2);
        bNode1.left = bNode2;
        bNode1.right = bNode3;
        System.out.println("expected = true , result = " + hasSubtree(aNode1, bNode1));
    }
}

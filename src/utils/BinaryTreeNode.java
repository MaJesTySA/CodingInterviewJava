package utils;

public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode parent;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public void preOrder() {
        System.out.print(this.value + "->");
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void inOrder() {
        if (this.left != null) {
            this.left.inOrder();
        }
        System.out.print(this.value + "->");
        if (this.right != null) {
            this.right.inOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this.value + "->");
    }
}

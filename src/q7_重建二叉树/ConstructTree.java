package q7_重建二叉树;

import utils.BinaryTreeNode;

public class ConstructTree {
    //普通二叉树
    private static int[] preOrderArr = {1, 2, 4, 7, 3, 5, 6, 8};
    private static int[] inOrderArr = {4, 7, 2, 1, 5, 3, 8, 6};

    //没有右节点
    //private static int[] preOrderArr = {1, 2, 3, 4, 5};
    //private static int[] inOrderArr = {5, 4, 3, 2, 1};

    //没有左节点
    //private static int[] preOrderArr = {1, 2, 3, 4, 5};
    //private static int[] inOrderArr = {1, 2, 3, 4, 5};

    //只有一个节点
    // private static int[] preOrderArr = {1};
    //private static int[] inOrderArr = {1};

    //完全二叉树
    //private static int[] preOrderArr = {1, 2, 4, 5, 3, 6, 7};
    //private static int[] inOrderArr = {4, 2, 5, 1, 6, 3, 7};

    //空
    //private static int[] preOrderArr = null;
    //private static int[] inOrderArr = {};

    //不匹配
    //private static int[] preOrderArr = {1, 2, 4, 5, 3, 6, 7};
    //private static int[] inOrderArr = {4, 2, 8, 1, 6, 3, 7};

    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BinaryTreeNode construct() throws Exception {
        if (preOrderArr == null || inOrderArr == null || preOrderArr.length <= 0)
            return null;
        return constructCore(0, preOrderArr.length - 1, 0, preOrderArr.length - 1);
    }

    /**
     * @param startPreOrder 前序序列的起始指针
     * @param endPreOrder   前序序列的结束指针
     * @param startInOrder  中序序列的起始指针
     * @param endInOrder    中序序列的结束指针
     * @return
     */
    private static BinaryTreeNode constructCore(int startPreOrder, int endPreOrder, int startInOrder, int endInOrder) throws Exception {
        //得到前序序列的起始指针，也就是根节点
        int rootValue = preOrderArr[startPreOrder];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        root.left = root.right = null;

        //如果只有一个元素，则返回
        if (startPreOrder == endPreOrder) {
            if (startInOrder == endInOrder && preOrderArr[startPreOrder] == inOrderArr[startInOrder]) {
                return root;
            } else {
                throw new Exception("Invalid input.");
            }
        }

        //中序中找到根节点
        int rootInOrderIndex = startInOrder;
        while (rootInOrderIndex < inOrderArr.length && inOrderArr[rootInOrderIndex] != rootValue) {
            rootInOrderIndex++;
        }

        //输入不匹配
        if (rootInOrderIndex == inOrderArr.length - 1 && inOrderArr[rootInOrderIndex] != rootValue) {
            throw new Exception("Invalid input.");
        }

        //左子树长度
        int leftLength = rootInOrderIndex - startInOrder;
        //前序左子树结束指针 =3 {4,7,2,1}
        int leftPreOrderEnd = startPreOrder + leftLength;
        //构建左子树
        if (leftLength > 0) {
            //前序 {1  ,  2,4,7  ,   3,5,6,8  } 即1~3的{2,4,7}；中序{4,7,2,   1,   5,3,8,6} 即0~2的{4,7,2}
            root.left = constructCore(startPreOrder + 1, leftPreOrderEnd, startInOrder, rootInOrderIndex - 1);
        }
        //构建右子树
        if (endPreOrder - startPreOrder - leftLength > 0) {
            //前序 {1  ,  2,4,7  ,   3,5,6,8  } 即4~7的{3,5,6,8}；中序{4,7,2,   1,   5,3,8,6} 即5~7的{5,3,8,6}
            root.right = constructCore(leftPreOrderEnd + 1, endPreOrder, rootInOrderIndex + 1, endInOrder);
        }
        return root;
    }

    private static void test() throws Exception {
        BinaryTreeNode node = construct();
        if (node == null) {
            System.out.println("空链表");
            return;
        }
        System.out.print("前序遍历： ");
        node.preOrder();
        System.out.print("\n中序遍历： ");
        node.inOrder();
    }
}


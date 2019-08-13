package q07_重建二叉树;

import utils.BinaryTreeNode;

public class ConstructTree {
    public static void main(String[] args) throws Exception {
        //普通二叉树
        test(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        //没有右节点
        test(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1});
        //没有左节点
        test(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
        //只有一个节点
        test(new int[]{1}, new int[]{1});
        //完全二叉树
        test(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 2, 5, 1, 6, 3, 7});
        //空
        test(null, new int[]{});
        //不匹配
        test(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 2, 8, 1, 6, 3, 7});
    }

    private static BinaryTreeNode construct(int[] preOrderArr, int[] inOrderArr) throws Exception {
        if (preOrderArr == null || inOrderArr == null || preOrderArr.length <= 0)
            return null;
        return constructCore(preOrderArr, inOrderArr,
                0, preOrderArr.length - 1,
                0, preOrderArr.length - 1);
    }

    private static BinaryTreeNode constructCore(int[] preOrderArr, int[] inOrderArr,
                                                int startPreOrder, int endPreOrder,
                                                int startInOrder, int endInOrder) throws Exception {
        //得到前序序列的起始指针，也就是根节点
        int rootValue = preOrderArr[startPreOrder];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        root.right = root.left = null;

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
        //前序左子树结束指针
        int leftPreOrderEnd = startPreOrder + leftLength;

        //构建左子树
        if (leftLength > 0) {
            root.left = constructCore(preOrderArr, inOrderArr,
                    startPreOrder + 1, leftPreOrderEnd,
                    startInOrder, rootInOrderIndex - 1);
        }
        //构建右子树
        if (endPreOrder - startPreOrder - leftLength > 0) {
            root.right = constructCore(preOrderArr, inOrderArr,
                    leftPreOrderEnd + 1, endPreOrder,
                    rootInOrderIndex + 1, endInOrder);
        }
        return root;
    }

    private static void test(int[] preOrderArr, int[] inOrderArr) throws Exception {
        BinaryTreeNode node = construct(preOrderArr, inOrderArr);
        if (node == null) {
            System.out.print("空链表");
            System.out.println("\n==============");
            return;
        }
        System.out.print("前序遍历： ");
        node.preOrder();
        System.out.print("\n中序遍历： ");
        node.inOrder();
        System.out.println("\n==============");
    }
}

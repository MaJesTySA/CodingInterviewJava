# 剑指Offer Java版
> 注：所有图片均来自[CyC2018](https://github.com/CyC2018)。

# 02_单例模式

> 实现一个单例模式。

[Singleton](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q02_单例模式/Singleton.java)

没什么好说的。

```java
public class Singleton {
    private static volatile Singleton singleton=null;
    private Singleton(){}
    public static Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton1=getInstance();
        Singleton singleton2=getInstance();
        System.out.println(singleton1==singleton2);//true
    }
}
```

# 03_数组中重复的数字

## 03_01_可以改变原数组

> 在一个长度为n的数组里的所有数组都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道重复了几次。请找出任意一个重复的数组。

[DuplicationInArray](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q03_01_%E6%95%B0%E7%BB%84%E9%87%8D%E5%A4%8D%E6%95%B0%E5%AD%97/DuplicationInArray.java)

### 哈希表解法

这个方法不需要改变原数组。遍历整个数组，对每一个数字进行判断，如果不在哈希表里面，则加入到哈希表；如果在哈希表里面，则添加进结果集，时间复杂度为O(n)，空间复杂度为O(n)。

```java
for (int i = 0; i < arr.length; i++) {
    if (numsMap.get(arr[i]) == null) {
        numsMap.put(arr[i], arr[i]);
    } else
        result.add(arr[i]);
}
```

### 原数组上修改解法

这个方法时间复杂度还是O(n)，但是空间复杂度降低到O(1)。并且只能找到第一个重复的数字。

思路就是，对于一个不重复的排序数组，比如[0,1,2,3,4,5,6]，它的**每一个值就等于它的下标值**。但是如果出现了重复，**总有一个值不等于它的下标值**，比如[0,1,2,3,4,5,6,6,6,7]，下标为7的值为6，两者不相等，这时就说明数组有重复元素。

![](https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/49d2adc1-b28a-44bf-babb-d44993f4a2e3.gif)

这个方法只能找到第一个重复的数字。

```java
for (int i = 0; i < arr.length; i++) {
    while (arr[i] != i) {
        if (arr[i] == arr[arr[i]]) {
            return true;
        } else {
            int temp = arr[i];
            arr[i] = arr[temp];
            arr[temp] = temp;
            }
        }
    }
return false;
```

# 04_二维数字中的查找

> 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有这个整数。

[FindIn2DArray]([https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q04_%E4%BA%8C%E7%BB%B4%E6%95%B0%E7%BB%84%E6%9F%A5%E6%89%BE%E5%85%83%E7%B4%A0/FindIn2DArray.java](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q04_二维数组查找元素/FindIn2DArray.java))

最笨的解法就是依次遍历查找。这里的数组显然是有**规律的**，可以用如下思路来求解（比较巧妙）。

查找数字16，首先选择右上角的数字15，跟15同行的数字都比15小，所以16不可能在第0行（从0开始），那么查找的范围缩小。

接着选取子数组的右上角数字19，跟19同列的都比19大，所以16不可能在第4列，范围继续缩小。

接着选取子数组的右上角数字12，跟12同行的都比12小，所以16不可能在第1行，范围继续缩小。

此时最右上角数字就是要查找的数字16，查找结束。

![](https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/0ad9f7ba-f408-4999-a77a-9b73562c9088.gif)

总结一下就是，选取数组最右上角的数字，如果等于要查找的数，结束；如果大于要查找的数，则删除该列；如果小于要查找的数，则删除该行。

```java
private static boolean find(int[][] arr, int target) {
    if (arr == null || arr.length < 0) {
        return false;
    }
    int row = 0;
    int column = arr.length - 1;
    while (row < arr.length && column >= 0) {
        if (arr[row][column] == target) {
            return true;
        //右上角的值大于目标值，目标值不可能在该列，column--
        } else if (arr[row][column] > target) {
            column--;
        //右上角的值小于目标值，目标值不可能在该行，row++
        } else {
            row++;
        }
    }
    return false;
}
```

# 05_替换空格

> 实现一个函数，把字符串的每个空格替换成“%20”。

[ReplaceBlank](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q05_%E6%9B%BF%E6%8D%A2%E7%A9%BA%E6%A0%BC/ReplaceBlank.java)

## 偷懒法

用一个`StringBuilder`，遍历原字符串，如果不是空格，就添加进`StringBuilder`，如果是空格，就添加`%20`。

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i) == ' ') {
        sb.append("%20");
    } else {
        sb.append(str.charAt(i));
    }
}
```

## 双指针法

先遍历原字符串，看有多少个空格，然后申请一个新的字符串数组，大小为**原字符串+空格数量*2**。

接下来，维护两个指针，一个指针为P1，指向**原字符串末尾**，另一个指针为P2，指向**新字符串末尾**。

随后，开始移动P1，如果**不是空格**，**就复制**。如果**遇到空格**，P1向前移动一格，**P2插入"%20"**。最后当P1=P2时，循环结束。

![](https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/6980aef0-debe-4b4b-8da5-8b1befbc1408.gif) 

```java
while (oldPtr != newPtr) {
    //不是空格就复制
    while (strChar[oldPtr] != ' ') {
        newStr[newPtr] = strChar[oldPtr];
        newPtr--;
        oldPtr--;
    }
    newStr[newPtr] = '%';
    newStr[newPtr - 1] = '0';
    newStr[newPtr - 2] = '2';
    //复制完空格后，指针移动
    newPtr = newPtr - 3;
    oldPtr--;
}
```

**双指针法**应用比较多，而且**从后向前操作**这种思想，也比较有用。

# 06_从尾打印链表

> 输入一个链表的头节点，从尾到头打印每个节点的值。

[PrintLListReversely](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q06_从尾打印链表/PrintLListReversely.java)

## 栈实现

先遍历第一次，把所有节点入栈，遍历完后出栈即可。

```java
private static void printWithStack(ListNode head) {
    if (head == null) {
        System.out.println("空链表");
        return;
    }
    Stack<ListNode> stack = new Stack<>();
    ListNode curNode = head;
    while (curNode != null) {
        stack.push(curNode);
        curNode = curNode.next;
    }
    while (!stack.isEmpty()) {
        System.out.print(stack.pop().value + "->");
    }
    System.out.println();
}
```

## 递归实现

栈和递归是等价的，也可以用递归实现。

```java
private static void printWithRecur(ListNode head) {
    if (head == null) {
        System.out.println("空链表");
        return;
    }
    if (head.next != null) {
        printWithRecur(head.next);
    }
    System.out.print(head.value + "->");
}
```

# 07_重建二叉树

> 输入某二叉树的前序遍历和中序遍历的结果，重建二叉树。

二叉树的前序遍历，**第一个节点总是根节点**。而中序遍历，**根节点在中间**，**左子树在根节点的左边**，**右子树在根节点的右边**，这就是规律。

首先得到**前序遍历数组**的第一个节点，也就是二叉树的根节点。然后在**中序遍历数组**中找到根节点，那么就能得到根节点的**左子树**和**右子树**。然后递归下去，即可构建。

```java
private static BinaryTreeNode constructCore(int[] preOrderArr, int[] inOrderArr,
                                                int startPreOrder, int endPreOrder,
                                                int startInOrder, int endInOrder) throws Exception {
    //得到前序序列的起始节点，也就是根节点
    int rootValue = preOrderArr[startPreOrder];
    BinaryTreeNode root = new BinaryTreeNode(rootValue);
    root.right = root.left = null;
    
    //如果只有一个元素，并且前序序列和中序序列值相等，就返回
    if (startPreOrder == endPreOrder) {
        if (startInOrder == endInOrder && preOrderArr[startPreOrder] == inOrderArr[startInOrder]) 
            return root;
        else 
            throw new Exception("Invalid input.");
    }
    
    //中序序列中找到根节点
    int rootInOrderIndex = startInOrder;
   while (rootInOrderIndex < inOrderArr.length && inOrderArr[rootInOrderIndex] != rootValue) 
       rootInOrderIndex++;
    
    //输入不匹配
    if (rootInOrderIndex == inOrderArr.length - 1 && inOrderArr[rootInOrderIndex] != rootValue) 
        throw new Exception("Invalid input.");

    //左子树长度
    int leftLength = rootInOrderIndex - startInOrder;
    //前序左子树结束指针
    int leftPreOrderEnd = startPreOrder + leftLength;

    //构建左子树
    if (leftLength > 0) 
        root.left = constructCore(preOrderArr, inOrderArr,
                    startPreOrder + 1, leftPreOrderEnd,
                    startInOrder, rootInOrderIndex - 1);
    //构建右子树
    if (endPreOrder - startPreOrder - leftLength > 0)
        root.right = constructCore(preOrderArr, inOrderArr,
                    leftPreOrderEnd + 1, endPreOrder,
                    rootInOrderIndex + 1, endInOrder);
    return root;
}
```

# 08_二叉树的下一个节点

> 给定一颗二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？一个节点除了有左右节点外，还有父节点。

[GetNextNode](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q08_二叉树的下一个节点/GetNextNode.java)

分三种情况：

①如果一个节点**有右子树**，那么该节点的下一节点就是**右子树的最左节点**。

![](https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/b0611f89-1e5f-4494-a795-3544bf65042a.gif)

②如果一个节点**没有右子树**，且它是**父节点的左子节点**，那么该节点的下一节点就是**其父节点**。

③如果一个节点**既没有右子树**，**又不是父节点的左子节点**，那么就**往上遍历**，直到找到一个节点是

它父节点的左子树的节点，这个结点的父节点就是下一个节点。

比如下图第一个节点，没有右子树，且不是父节点的左节点。此时来到它的父节点，它的父节点又是祖父节点的右节点，继续往上遍历，此时曾祖父节点是根节点的左节点，那么根节点就是下一个节点。

![](https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/95080fae-de40-463d-a76e-783a0c677fec.gif)

```java
private static BinaryTreeNode getNextNode(BinaryTreeNode node) {
    if (node == null)
        return null;
    BinaryTreeNode nextNode = null;
    //如果该节点右节点不为空，则找右节点的最左节点
    if (node.right != null) {
        BinaryTreeNode tempNode = node.right;
        while (tempNode.left != null) {
            tempNode = tempNode.left;
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
```


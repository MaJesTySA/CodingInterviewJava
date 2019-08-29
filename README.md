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

# 03_01_数组中重复的数字

> 在一个长度为n的数组里的所有数组都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道重复了几次。请找出任意一个重复的数组。

[DuplicationInArray](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q03_01_%E6%95%B0%E7%BB%84%E9%87%8D%E5%A4%8D%E6%95%B0%E5%AD%97/DuplicationInArray.java)

## 哈希表解法

这个方法不需要改变原数组。遍历整个数组，对每一个数字进行判断，如果不在哈希表里面，则加入到哈希表；如果在哈希表里面，则添加进结果集，时间复杂度为O(n)，空间复杂度为O(n)。

```java
for (int i = 0; i < arr.length; i++) {
    if (numsMap.get(arr[i]) == null) {
        numsMap.put(arr[i], arr[i]);
    } else
        result.add(arr[i]);
}
```

## 原数组上修改解法

这个方法时间复杂度还是O(n)，但是空间复杂度降低到O(1)。并且只能找到第一个重复的数字。

思路就是，对于一个不重复的排序数组，比如[0,1,2,3,4,5,6]，它的**每一个值就等于它的下标值**。但是如果出现了重复，**总有一个值不等于它的下标值**，比如[0,1,2,3,4,5,6,6,6,7]，下标为7的值为6，两者不相等，这时就说明数组有重复元素。

<img src="https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/49d2adc1-b28a-44bf-babb-d44993f4a2e3.gif" width=30% />

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

<img src="https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/0ad9f7ba-f408-4999-a77a-9b73562c9088.gif" width=30%/>

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

<img src="https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/6980aef0-debe-4b4b-8da5-8b1befbc1408.gif" width=30%/>

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

<img src="https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/b0611f89-1e5f-4494-a795-3544bf65042a.gif" width=30% />

②如果一个节点**没有右子树**，且它是**父节点的左子节点**，那么该节点的下一节点就是**其父节点**。

③如果一个节点**既没有右子树**，**又不是父节点的左子节点**，那么就**往上遍历**，直到找到一个节点是

它父节点的左子树的节点，这个结点的父节点就是下一个节点。

比如下图第一个节点，没有右子树，且不是父节点的左节点。此时来到它的父节点，它的父节点又是祖父节点的右节点，继续往上遍历，此时曾祖父节点是根节点的左节点，那么根节点就是下一个节点。

<img src="https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/95080fae-de40-463d-a76e-783a0c677fec.gif" width=30%/>

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

# 09_两个栈实现队列

## 两个栈实现队列

> 用两个栈实现一个队列，完成在队列尾部插入节点，队列头部删除节点的功能

[QueueWithTwoStacks](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q09_两个栈实现队列/QueueWithTwoStacks.java)

总是把新元素添加进`stack1`。取出的话，当`stack2`不为空时，栈顶就是出队元素。为空时，则把`stack1`的元素依次压入`stack2`。

<img src="https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/3ea280b5-be7d-471b-ac76-ff020384357c.gif" width=50% />

```java
public void append(T node){
    stack1.push(node);
}

public T delete(){
    if (stack2.size()<=0){
        while (stack1.size()>0){
            stack2.push(stack1.pop());
        }
    }
    if (stack2.size()==0){
        System.out.println("队列已空");
        return null;
    }
    return stack2.pop();
}
```

## 两个队列实现栈

[StackWithTwoQueue](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q09_两个栈实现队列/StackWithTwoQueue.java)

```java
public void push(T node) {
    queue1.addLast(node);
}

public T pop() {
    if (queue1.size() + queue2.size() > 0) {
        //队列1为空，就把除队尾元素之外的所有元素放入队列2，则队列1剩下的元素，就是弹栈元素
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1)
                queue2.addLast(queue1.removeFirst());
            return queue1.removeFirst();
        //队列2为空，倒转逻辑。
        } else {
            while (queue2.size() > 1)
                queue1.addLast(queue2.removeFirst());
            return queue2.removeFirst();
        }
    } else {
        System.out.println("空栈");
        return null;
    }
}
```

# 10_斐波那契数列

> 求斐波那契数列第n项

[Fibonacci](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q10_斐波那契/Fibonacci.java)

## 递归

递归的性能较低，会导致大量重复计算。

```java
private static int fibWithRecur(int n) {
    if (n <= 0)
        return 0;
    if (n == 1)
        return 1;
    return fibWithRecur(n - 1) + fibWithRecur(n - 2);
}
```

## 循环

循环可以利用之前计算的结果，性能比递归高。

```java
private static int fibWithWhile(int n) {
    if (n <= 0)
        return 0;
    if (n == 1)
        return 1;
    int fibNMinusOne = 1;
    int fibNMinusTwo = 0;
    int fibN = 0;
    for (int i = 2; i <= n; i++) {
        fibN = fibNMinusOne + fibNMinusTwo;
        fibNMinusTwo = fibNMinusOne;
        fibNMinusOne = fibN;
    }
    return fibN;
}
```

# 11_旋转数组的最小数字

> 把一个数字最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个**递增排序**的数组的一个旋转，输出旋转数组的最小元素。例如，数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，最小值为1。

[FindRotateMin](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q11_旋转数组找到最小值/FindRotateMin.java)

最直观的解法就是就是从头到尾遍历，找到最小的数，时间复杂度是O(N)。注意，是**递增排序**的数组，看到**递增排序**，就要想到**二分法**。

将旋转后的数组分成**两个序列**，一个是前面的大值序列，一个是后面的小值序列，大小序列的分界点，就是最小元素。维护**两个指针**，一个指向前面序列的第一个元素，一个指向后面序列的最后一个元素。

每一次，取中间值，如果中间值**大于第一个指针**，那么最小值只可能在它的**后面**，所以让第一个指针指向中间值。如果中间值**小于第二个指针**，那么最小值只可能在它的**前面**，所以让第二个指针指向中间值。

当两个指针的距离为1时，表明第一个指针已经到了大值序列的尾部，第二个指针已经到了小值序列的头部，所以小值序列的头部就是最小数字。

当然，也有特殊情况，当第一个指针和第二个指针，以及中间值都一样时，只能通过顺序查找的方式查找。

```java
private static int findMin(int[] arr) throws Exception {
    if (arr == null || arr.length <= 0)
        throw new Exception("数组为空！");
    int start = 0;
    int end = arr.length - 1;
    //考虑到本身就是有序的情况，那么第一个元素就是最小值
    if (arr[start] < arr[end]) {
        return arr[start];
    }
    while (end - start != 1) {
        int mid = (start + end) / 2;
        //使用顺序查找
        if (arr[start] == arr[end] && arr[start] == arr[mid]) {
            return orderFind(arr, start, end);
        }
        //中间值大于起始值，中间值位于前面的序列，最小值在中间值的右边。
        if (arr[mid] >= arr[start])
            start = mid;
        else if (arr[mid] <= arr[end]) {
            end = mid;
        }
    }
    return arr[end];
}

private static int orderFind(int[] arr, int start, int end) {
    int res = arr[start];
    for (int i = start + 1; i <= end; i++) {
        if (res > arr[i]) {
            res = arr[i];
        }
    }
    return res;
}
```

# 12_矩阵中的路径

> 设计一个函数，用来判断一个矩阵中是否存在一条包含某个字符串所有字符的路径。路径可以从矩阵中的**任意一格**开始，每一步可以在矩阵中向**四个方向**移动一格。**如果进入过了，就不能再次进入**。

[PathInMatrix](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q12_矩阵中的路径/PathInMatrix.java)

典型的**回溯法**问题。从头到尾遍历每个矩阵的字符。

```java
private static boolean hasPath(char[][] matrix, String str) {
    if (matrix == null || matrix.length <= 0 || str == null || str.length() == 0) 
        return false;
    int rows = matrix.length;
    int cols = matrix[0].length;
    boolean[][] visited = new boolean[rows][cols];
    int pathLength = 0;
    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            if (hasPathCore(matrix, row, col, str, pathLength, visited)) {
                return true;
            }
        }
    }
    return false;
}
```

如果**当前字符**等于**字符串所在位置的字符**，那么就使`pathLength++`，并且`visited`为true，接着从四个方向，重复该步骤。如果四个方向都走不通，就会返回false，那就说明这条路径也走不通，那就回去，`pathLength--`，并置`visited`为false。

```java
private static boolean hasPathCore(char[][] matrix, int row, int col, String str, int pathLength, boolean[][] visited) {
    if (pathLength == str.length())
        return true;
    boolean hasPath = false;
    int rows = matrix.length;
    int cols = matrix[0].length;

    if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row][col] == str.charAt(pathLength)
                && !visited[row][col]) {
        ++pathLength;
        visited[row][col] = true;
		//看该格子的四个方向能否走通
        hasPath = hasPathCore(matrix, row, col - 1, str, pathLength, visited) ||
                    hasPathCore(matrix, row - 1, col, str, pathLength, visited) ||
                    hasPathCore(matrix, row, col + 1, str, pathLength, visited) ||
                    hasPathCore(matrix, row + 1, col, str, pathLength, visited);
        //走不通就回溯
        if (!hasPath) {
            --pathLength;
            visited[row][col] = false;
        }
    }
    return hasPath;
}
```

# 13_机器人的运动范围

> 地上有一个m*n的方格，一个机器人从坐标(0,0)开始移动，每次只能向四个方向移动1格，但不能进入行坐标和列坐标之和大于k的格子。例如当k=18时，机器人能够进入方格(35,37)，以为3+5+3+7=18，但不能进入(35,38)。请问该机器人能够到达多少个格子？

[RobotMove](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q13_机器人运动范围/RobotMove.java)

思路跟12题类似，也是回溯法，只是需要增加进入的条件。

```java
private static int getDigitSum(int number) {
    int sum = 0;
    while (number > 0) {
        sum += number % 10;
        number /= 10;
    }
    return sum;
}

//检查能否进入matrix[row][col]
private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
    return (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold
                && !visited[row][col]);
}
```

然后开始回溯。

```java
private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
    int count = 0;
    if (check(threshold, rows, cols, row, col, visited)) {
        visited[row][col] = true;
        count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row, col - 1, visited) +
                    movingCountCore(threshold, rows, cols, row + 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row, col + 1, visited);
    }
    return count;
}
```

# 14_剪绳子

> 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，且都大于1），每段绳子的长度即为k[0]，k[1]，k[2]，···，k[m]。请问最大乘积是多少？

[CuttingRope](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q14_剪绳子/CuttingRope.java)

## 动态规划

假设f(n)表示把长度为n的绳子剪成若干段后，乘积的最大值。那么剪第一刀，有n-1种结果：1和n-1，2和n-2，i和n-i。那么`f(n)=max(f(i)*f(n-i))`。注意，当绳长<4时，最大的绳长就是不剪，比如绳长为3，最大的就是它自己1x3=3，而不是两段，1x2=2。当绳长大于等于4时，最大的绳长需要剪。

```java
private static int maxProductAfterCutting_DP(int length) {
    if (length < 2)
        return 0;
    if (length == 2)
        return 1;
    if (length == 3)
        return 2;
    //products储存每段最大的乘积
    int[] products = new int[length + 1];
    //为什么products[3]=3，而不是2，是因为如果长度大于3,3可以不减。
    products[1] = 1;
    products[2] = 2;
    products[3] = 3;
    int max;
    for (int i = 4; i <= length; i++) {
        max = 0;
        for (int j = 1; j <= i / 2; j++) {
            int product = products[j] * products[i - j];
            if (max < product)
                max = product;
            products[i] = max;
        }
    }
    max = products[length];
    return max;
}
```

## 贪心算法

尽可能得剪长度为3的绳子，当最后剩下的长度为4时，不能再去剪长度为3的绳子。因为2x2>1x3。

```java
private static int maxProductAfterCutting_GA(int length) {
    if (length < 2)
        return 0;
    if (length == 2)
        return 1;
    if (length == 3)
        return 2;
    int timesOf3 = length / 3;
    if (length - timesOf3 * 3 == 1)
        timesOf3 -= 1;
    int timesOf2 = (length - timesOf3 * 3) / 2;
    return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
}
```

# 15_二进制中1的个数

> 实现一个函数，输入一个整数，输出该数二进制表示中1的个数。

[NumberOf1InBinary](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q15_二进制1的个数/NumberOf1InBinary.java)

## 可能引起死循环的解法

很自然的想到，让该数与1与，为1就表示该位为1。然后右移该数，直到为0。

```java
private static int numberOfOneRight(long n) {
    int count = 0;
    while (n != 0) {
        if ((n & 1) > 0) {
            count++;
        }
        n = n >> 1;
    }
    return count;
}
```

这个方法有个缺陷，如果输入的是个负数，使用>>（符号右移），最高位始终是1，会导致死循环（始终在0xFFFF循环）。

## 常规解法

我们不再移动该数，而是移动一个标志位，每一次让该标志位左移1位。

```java
private static int numberOfOneLeft(long n) {
    int count = 0;
    int flag = 1;
    //& 0xFFFF
    while (flag != 0) {
        if ((n & flag) > 0) 
            count++;
        flag = flag << 1;
    }
    return count;
}
```

这种解法每一位都需要循环`Integer.MAX_VALUE/2`次。

## 巧解法

一个数减去1后再与自身与，就能把该数最右边的1变成0，count++，直到该数为0。

```java
private static int numberOfOneMinus(long n) {
    int count = 0;
    while (n != 0) {
        count++;
        n = (n - 1) & n;
    }
    return count;
}
```

# 16_数值的整数次方

> 实现一个次方函数

[Power](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q16_数值的整数次方/Power.java)

## 循环解法

```java
private static double pow(double base, int exp) {
    invalidInput = false;
    if (base == 0.0 && exp < 0) {
        invalidInput = true;
        return 0.0;
    }
    if (exp < 0) {
        double result = power(base, -exp);
        return 1.0 / result;
    }
    return power(base, exp);
}

private static double power(double base, int exp) {
    double result = 1.0;
    for (int i = 0; i < exp; i++) {
        result *= base;
    }
    return result;
}
```

## 位运算法

```java
private static double powWithBit(double base, int exp) {
    invalidInput = false;
    if (base == 0.0 && exp < 0) {
        invalidInput = true;
        return 0.0;
    }
    if (exp < 0) {
        double result = powerWithBit(base, -exp);
        return 1.0 / result;
    }
    return powerWithBit(base, exp);
}

private static double powerWithBit(double base, int exp) {
    if (exp == 0)
        return 1;
    if (exp == 1)
        return base;
    double result = powerWithBit(base, exp >> 1);
    result *= result;
    //如果exp是奇数
    if ((exp & 0x1) == 1)
        result *= base;
    return result;
}
```

# 17_打印从1到最大的n位数

> 输入数字n，按顺序打印从1到最大的n位十进制数。

[Print1ToMaxOfNDigits](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q17_打印1到最大的n位数/Print1ToMaxOfNDigits.java)

## 想当然的解法

```java
private static void print(int n) {
    for (int i = 0; i < (int) Math.pow(10, n); i++) 
        System.out.print(i + "\t");
}
```

这种解法无法处理当n超过int，甚至long范围的情况。所以应该用字符串来处理。

# 18_01_删除链表节点

> 在O(1)时间内删除链表节点

[DeleteNodeInList](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q18_01_删除链表的节点/DeleteNodeInList.java)

## 常规解法

遍历整个链表，当当前节点下一个节点为要删除节点时，令当前节点下一个节点为要删除节点的下一个节点。时间复杂度是O(n)。

```java
ListNode curNode=head;
while (curNode.next!=deleted)
    curNode=curNode.next;
curNode.next=deleted.next;
```

## O(1)解法

不需要遍历，先取出需要删除节点`deleted`的下一个节点`next`，然后将`next`复制给删除节点`deleted`，最后让`deleted.next`指向`next.next`即可。

```java
private static ListNode delete(ListNode head, ListNode deleted) {
    if (head == null || deleted == null) 
        return;
    if (deleted.next != null) {
        //找到被删除节点的下一个节点
        ListNode next = deleted.next;
        //将下一个节点的内容，复制给被删除节点
        deleted.value = next.value;
        //由于被删除节点的Next指向了删除节点Next的Next，所以next成了垃圾，会被GC
        deleted.next = next.next;
    } else if (head == deleted) {
        head = null;
    //删除尾节点
    } else {
        ListNode tmp = head;
        while (tmp.next != deleted) {
            tmp = tmp.next;
        }
        tmp.next = null;
    }
    return head;
}
```

# 18_02_删除链表重复节点

> 一个排序的链表中，删除重复节点

[DeleteDuplicatedNode](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q18_02_删除链表重复节点/DeleteDuplicatedNode.java)

维护两个指针，一个`preNode`，一个`curNode`，`preNode`是`curNode`的前一个结点。

遍历链表，如果当前节点与下一个节点值不相等，移动`curNode`和`preNode`。否则，记标志位`needDelete`为`true`。然后令`deleteNode`为当前节点，如果`curNode.value == deleteNode.value`，那么就移动`deleteNode`，直到不等。此时，`deleteNode`指向了下一个不重复的节点，令`preNode.next`等于它即可。

```java
private static ListNode deleteDup(ListNode head) {
    if (head == null || head.next == null)
        return head;
    ListNode preNode = null;
    ListNode curNode = head;
    while (curNode != null) {
        ListNode nextNode = curNode.next;
        boolean needDelete = false;
        if (nextNode != null && nextNode.value == curNode.value)
            needDelete = true;
        if (!needDelete) {
            preNode = curNode;
            curNode = curNode.next;
        } else {
            ListNode deleteNode = curNode;
            while (deleteNode != null && deleteNode.value == curNode.value) {
                deleteNode = deleteNode.next;
            }
            if (preNode == null)
                head = deleteNode;
            else
                preNode.next = deleteNode;
            curNode = deleteNode;
        }
    }
    return head;
}
```

# 20_表示数值的字符串

> 实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

[NumericStrings](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q20_表示数值的字符串/NumericStrings.java)

表示数值的字符串遵循A&#91;.[B]]&#91;e|EC]或者.B&#91;e|EC]，其中A为数值的整数部分，B是小数部分的数值，C指数后的数字。

```java
private static boolean isNumeric(String str) {
    pos = 0;
    if (str == null || str.length() <= 0)
        return false;
    boolean numeric = scanInteger(str);
    if (pos < str.length() && str.charAt(pos) == '.') {
        ++pos;
    /*
    小数点的前面可以没有整数部分，比如.123等于0.123，也就是说numeric为false时，整体也要为真
    小数点的后面可以没有数字，比如233.等于233.0，此时前面为false。
    当然也可以前后都有数字，都为true。所以是||的关系。
    */
        numeric = scanUnsignedInt(str) || numeric;
    }
    if (pos < str.length() && (str.charAt(pos) == 'e' || str.charAt(pos) == 'E')) {
        ++pos;
        /*
        指数的前面没有数字时，整个字符串不能表示数字，比如.e1、e1
        指数的后面没有整数时，整个字符串不能表示数字，比如12e、12e+5.4
        */
        numeric = numeric && scanInteger(str);
    }
    return numeric && pos == str.length();
}

private static boolean scanInteger(String str) {
    // +、- 不是必须，遇到+、-就向后移，检查是否有数字
    if (pos < str.length() && (str.charAt(pos) == '+' || str.charAt(pos) == '-'))
        ++pos;
        return scanUnsignedInt(str);
    }

private static boolean scanUnsignedInt(String str) {
    int tempPos = pos;
    while (pos < str.length() && str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
        ++pos;
    }
    //有数字则返回true，没数字则返回false
    return pos > tempPos;
}
```

# 21_调整数组顺序使奇数在偶数前

> 输入一个整数数组，实现一个函数将数组中奇数移动到偶数前面

[ReorderArray](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q21_调整数组顺序奇在偶前/ReorderArray.java)

维护两个指针，一个在首，一个在尾。第一个指针遇到偶数就停下，第二个指针遇到奇数就停下，然后交换。重复这个过程。

```java
private static void generalReorderOddEven(int[] arr) {
    if (arr.length == 0 || arr == null)
        return;
    int start = 0;
    int end = arr.length - 1;
    while (end > start) {
        //前面的指针不是偶数，就++
        while (end > start && !isEven(arr[start]))
            start++;
        //后面的指针不是奇数，就--
        while (end > start && isEven(arr[end]))
            end--;
        //交换
        if (end > start) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
}
```

# 22_链表中倒数第k个节点

> 输入一个链表，输出该链表的倒数第k个节点。从1开始计数，尾节点即是倒数第1个节点。

[KthNodeFromEnd](https://github.com/MaJesTySA/CodingInterviewJava/blob/master/src/q22_链表倒数第k个节点/KthNodeFromEnd.java)

## 常规解法

先遍历整个链表，得到总节点数n。再第二次遍历n-k+1次，即可得到倒数第k个节点。

## 遍历一次解法

维护两个指针，先让一个指针走k-1步，然后两者一起走，当第一个指针到达尾部时，第二个指针刚好达到倒数第k个节点。

```java
private static ListNode findKthToTail(ListNode head, int k) {
    if (head == null || k == 0)
        return null;
    ListNode ahead = head;
    ListNode behind = head;
    for (int i = 0; i < k - 1; i++) {
        //这个判断处理当链表数量<k的情况
        if (ahead.next != null)
            ahead = ahead.next;
        else
            return null;
    }
    while (ahead.next != null) {
        ahead = ahead.next;
        behind = behind.next;
    }
    return behind;
}
```


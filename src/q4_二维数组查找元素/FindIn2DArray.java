package q4_二维数组查找元素;

public class FindIn2DArray {
    public static void main(String[] args) {
        int[][]arr={{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find(arr,2));
    }

    private static boolean find(int[][] arr,int target){
        if (arr==null||arr.length<0){
            return false;
        }
        int row=0;
        int column=arr.length-1;
        while (row<arr.length&&column>=0){
            if (arr[row][column]==target){
                return true;
            } else if (arr[row][column]>target){
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}


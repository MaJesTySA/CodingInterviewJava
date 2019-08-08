package q11_旋转数组找到最小值;

public class FindRotateMin {
    public static void main(String[] args) {
        try {
            System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
            System.out.println(findMin(new int[]{3, 4, 5, 1, 1, 2}));
            System.out.println(findMin(new int[]{3, 4, 5, 1, 2, 2}));
            System.out.println(findMin(new int[]{1, 0, 1, 1, 1}));
            System.out.println(findMin(new int[]{1, 2, 3, 4, 5}));
            System.out.println(findMin(new int[]{2}));
            System.out.println(findMin(new int[]{}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int findMin(int[] arr) throws Exception {
        if (arr == null || arr.length <= 0)
            throw new Exception("数组为空！");
        int start = 0;
        int end = arr.length - 1;
        if (arr[start] < arr[end]) {
            return arr[start];
        }
        while (end - start != 1) {
            int mid = (start + end) / 2;
            if (arr[start] == arr[end] && arr[start] == arr[mid]) {
                return orderFind(arr, start, end);
            }
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
}

package q57_01_和为s的数字;

import java.util.ArrayList;

public class TwoNumbersWithSum {
    public static void main(String[] args) {
        test("Test1", new int[]{1, 2, 4, 7, 11, 15}, 15);
        test("Test2", new int[]{1, 2, 4, 7, 11, 16}, 17);
        test("Test3", new int[]{1, 2, 4, 7, 11, 16}, 10);
        test("Test4", null, 10);
    }

    private static ArrayList<Integer> findTwoNumbersWithSum(int[] data, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (data == null || data.length < 1)
            return null;
        int ahead = 0;
        int behind = data.length - 1;
        while (ahead < behind) {
            int curSum = data[ahead] + data[behind];
            if (curSum == sum) {
                result.add(data[ahead]);
                result.add(data[behind]);
                break;
            }
            //当前和比期望和大，移动最大端
            else if (curSum > sum)
                behind--;
            else
                ahead++;
        }
        return result;
    }

    private static void test(String name, int[] data, int expected) {
        System.out.print(name + ": ");
        ArrayList res = findTwoNumbersWithSum(data, expected);
        if (res != null && res.size() > 0) {
            int res1 = (Integer) res.get(0);
            int res2 = (Integer) res.get(1);
            System.out.println(res1 + "+" + res2 + "=" + expected);
        } else {
            System.out.println("Not Find!");
        }
    }

}

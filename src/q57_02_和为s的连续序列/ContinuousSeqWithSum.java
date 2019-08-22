package q57_02_和为s的连续序列;

import java.util.ArrayList;
import java.util.Arrays;

public class ContinuousSeqWithSum {
    public static void main(String[] args) {
        test("Test1", 1);
        test("Test2", 3);
        test("Test3", 4);
        test("Test4", 9);
        test("Test5", 15);
        test("Test6", 100);
    }

    private static ArrayList<ArrayList<Integer>> findContinuousSeq(int sum) {
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        if (sum < 3)
            return null;
        int small = 1;
        int big = 2;
        int mid = (1 + sum) / 2;
        int curSum = small + big;
        while (small < mid) {
            if (curSum == sum) {
                ArrayList<Integer> result = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    result.add(i);
                }
                finalResult.add(result);
            }
            while (curSum > sum && small < mid) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    ArrayList<Integer> result = new ArrayList<>();
                    for (int i = small; i <= big; i++) {
                        result.add(i);
                    }
                    finalResult.add(result);
                }
            }
            big++;
            curSum += big;
        }
        return finalResult;
    }

    private static void test(String name, int sum) {
        System.out.print(name + ": ");
        ArrayList<ArrayList<Integer>> res = findContinuousSeq(sum);
        if (res != null && res.size() > 0) {
            System.out.println(Arrays.toString(res.toArray()));
        } else
            System.out.println("NOT FIND!");
    }


}

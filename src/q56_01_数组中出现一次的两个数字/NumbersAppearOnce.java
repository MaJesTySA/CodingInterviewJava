package q56_01_数组中出现一次的两个数字;

import java.util.ArrayList;


public class NumbersAppearOnce {
    public static void main(String[] args) {
        test("Test1", new int[]{2, 4, 3, 6, 3, 2, 5, 5}, 4, 6);
        test("Test2", new int[]{4, 6}, 4, 6);
        test("Test3", new int[]{4, 6, 1, 1, 1, 1}, 4, 6);
    }

    private static ArrayList<Integer> findNumsAppearOnce(int[] data) {
        ArrayList<Integer> result = new ArrayList<>(2);
        int num1 = 0;
        int num2 = 0;
        if (data == null || data.length < 2)
            return null;
        int resultXOR = 0;
        for (int i = 0; i < data.length; i++) {
            resultXOR ^= data[i];
        }
        int indexOf1 = findFirstBitIs1(resultXOR);
        for (int i = 0; i < data.length; i++) {
            if (isBit1(data[i], indexOf1))
                num1 ^= data[i];
            else
                num2 ^= data[i];
        }
        result.add(num1);
        result.add(num2);
        return result;
    }

    //找到第一个1的位置。
    private static int findFirstBitIs1(int num) {
        int indexBit = 0;
        while (((num & 1) == 0) && indexBit < 32) {
            num = num >> 1;
            indexBit++;
        }
        return indexBit;
    }

    //判断某一位是否是1，先右移indexBit位，再与1与。
    private static boolean isBit1(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;
    }

    private static void test(String name, int[] data, int exp1, int exp2) {
        System.out.print(name + ": ");
        ArrayList result = findNumsAppearOnce(data);
        int res1 = (Integer) result.get(0);
        int res2 = (Integer) result.get(1);
        if ((res1 == exp1 && res2 == exp2) || (res1 == exp2 && res2 == exp1))
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }
}

package q14_剪绳子;

public class CuttingRope {
    public static void main(String[] args) {
        test("Test1", 1, 0);
        test("Test2", 2, 1);
        test("Test3", 3, 2);
        test("Test4", 4, 4);
        test("Test5", 5, 6);
        test("Test6", 6, 9);
        test("Test7", 7, 12);
        test("Test8", 8, 18);
        test("Test9", 9, 27);
        test("Test10", 10, 36);
        test("Test11", 50, 86093442);

    }

    private static int maxProductAfterCutting_DP(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
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

    private static void test(String name, int length, int expected) {
        System.out.println(name + ": ");
        System.out.print("Test with DP: ");
        if (maxProductAfterCutting_DP(length) == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
        System.out.print("Test with DA: ");
        if (maxProductAfterCutting_GA(length) == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
        System.out.println("=================");
    }

}

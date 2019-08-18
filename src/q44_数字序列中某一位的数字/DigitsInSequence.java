package q44_数字序列中某一位的数字;

public class DigitsInSequence {
    public static void main(String[] args) {
        test("Test1", 0, 0);
        test("Test2", 1, 1);
        test("Test3", 9, 9);
        test("Test4", 10, 1);
        test("Test5", 189, 9);  // 数字99的最后一位，9
        test("Test6", 190, 1);  // 数字100的第一位，1
        test("Test7", 1000, 3); // 数字370的第一位，3
        test("Test8", 1001, 7); // 数字370的第二位，7
        test("Test9", 1002, 0); // 数字370的第三位，0
    }

    private static int digitAtIndex(int index) {
        if (index < 0)
            return -1;
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits)
                return digitAtIndex(index, digits);
            index -= digits * numbers;
            digits++;
        }
    }

    private static int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++)
            number /= 10;
        return number % 10;
//        int number = beginNumber(digits) + index / digits;
//        int moveIndex = index - digits * (index / digits);
//        for (int i = 0; i < digits - 1 - moveIndex; i++)
//            number /= 10;
//        return number % 10;
    }

    private static int countOfIntegers(int digits) {
        if (digits == 1)
            return 10;
        return 9 * (int) Math.pow(10, digits - 1);
    }

    private static int beginNumber(int digits) {
        if (digits == 1)
            return 0;
        return (int) Math.pow(10, digits - 1);
    }

    private static void test(String name, int input, int expected) {
        System.out.print(name + ": ");
        if (expected == digitAtIndex(input))
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }

}

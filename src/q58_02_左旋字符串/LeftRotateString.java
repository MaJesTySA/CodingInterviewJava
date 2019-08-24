package q58_02_左旋字符串;

import q58_01_反转单词.ReverseWords;

public class LeftRotateString {
    public static void main(String[] args) {
        test("Test1", "abcdefg", 2, "cdefgab");
        test("Test2", "abcdefg", 1, "bcdefga");
        test("Test3", "abcdefg", 6, "gabcdef");
        test("Test4", "abcdefg", 7, "abcdefg");
    }

    private static String leftRotate(String str, int n) {
        if (str == null || str.length() < 0 || n < 0 || n > str.length())
            return null;
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < n; i++) {
            sb.append(str.charAt(i));
        }
        sb.delete(0, n);
        return sb.toString();
    }

    private static char[] leftRotate(char[] strChar, int n) {
        if (strChar != null) {
            int length = strChar.length;
            if (length > 0 && n > 0 && n < length) {
                int firstStart = 0;
                int firstEnd = n - 1;
                int secondStart = n;
                int secondEnd = length - 1;
                ReverseWords.reverse(strChar, firstStart, firstEnd);
                ReverseWords.reverse(strChar, secondStart, secondEnd);
                ReverseWords.reverse(strChar, firstStart, secondEnd);
            }
        }
        return strChar;
    }

    private static void test(String name, String str, int n, String expected) {
        System.out.print(name + " With StringBuilder: ");
        if (expected.equals(leftRotate(str, n)))
            System.out.print("Passed.     ");
        else
            System.out.print("Failed.     ");
        System.out.print(name + " With Custom: ");
        if (expected.equals(String.valueOf(leftRotate(str.toCharArray(), n))))
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }
}

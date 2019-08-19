package q48_最长不含重复子串;

public class LongestSubstringWithoutDup {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
    }

    private static int longestSubStringNoDup(String str) {
        int curLength = 0;
        int maxLength = 0;
        //存放某个字母上次出现的位置，默认为-1
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }
        for (int i = 0; i < str.length(); i++) {
            //该字母上一次出现的位置
            int preIndex = position[str.charAt(i) - 'a'];
            //如果没有出现，或者与前一个字母的距离d大于当前长度，则直接+1
            if (preIndex < 0 || i - preIndex > curLength) {
                ++curLength;
            } else {
                if (curLength > maxLength)
                    maxLength = curLength;
                curLength = i - preIndex;
            }
            position[str.charAt(i) - 'a'] = i;
        }
        if (curLength > maxLength)
            maxLength = curLength;
        return maxLength;
    }

    private static void test(String name, String str, int expected) {
        System.out.print(name + ": ");
        if (longestSubStringNoDup(str) == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }

    private static void test1() {
        test("Test1", "abcacfrar", 4);
    }

    private static void test2() {
        test("Test2", "acfrarabc", 4);
    }

    private static void test3() {
        test("Test3", "arabcacfr", 4);
    }

    private static void test4() {
        test("Test4", "aaaa", 1);
    }

    private static void test5() {
        test("Test5", "abcdefg", 7);
    }

    private static void test6() {
        test("Test6", "aaabbbccc", 2);
    }

    private static void test7() {
        test("Test7", "abcdcba", 4);
    }

    private static void test8() {
        test("Test8", "abcdaef", 6);
    }

    private static void test9() {
        test("Test9", "a", 1);
    }

    private static void test10() {
        test("Test10", "", 0);
    }


}

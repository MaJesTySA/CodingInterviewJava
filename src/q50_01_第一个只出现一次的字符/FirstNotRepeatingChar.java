package q50_01_第一个只出现一次的字符;

import java.util.HashMap;

public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        // 常规输入测试，存在只出现一次的字符
        test("google", 'l');
        // 常规输入测试，不存在只出现一次的字符
        test("aabccdbd", '0');
        // 常规输入测试，所有字符都只出现一次
        test("abcdefg", 'a');
        // 鲁棒性测试，输入nullptr
        test(null, '0');
    }

    private static Character firstNotRepeating(String str) {
        if (str == null)
            return '0';
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.get(ch) == null) {
                map.put(ch, 1);
            } else {
                int count = map.get(ch);
                count++;
                map.put(ch, count);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.get(ch) == 1)
                return ch;
        }
        return '0';
    }

    private static void test(String str, Character expected) {
        if (firstNotRepeating(str).equals(expected))
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }
}

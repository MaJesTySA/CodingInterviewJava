package q58_01_反转单词;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(String.valueOf(reverseSentence("I am a student.")));
        System.out.println(String.valueOf(reverseSentence("wonderful")));
        System.out.println(String.valueOf(reverseSentence("you are so beautiful!")));
        System.out.println(String.valueOf(reverseSentence("w abc eee qq")));
        System.out.println(String.valueOf(reverseSentence("")));
        System.out.println(String.valueOf(reverseSentence("   ")));
    }

    public static void reverse(char[] str, int begin, int end) {
        if (begin < 0 || end < 0 || str == null || str.length < 0)
            return;
        while (begin < end) {
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin++;
            end--;
        }
    }

    private static char[] reverseSentence(String str) {
        if (str == null)
            return null;
        char[] strChar = str.toCharArray();
        int begin = 0;
        int end = str.length() - 1;
        reverse(strChar, begin, end);
        end = 0;
        while (begin < strChar.length - 1) {
            if (end < strChar.length && strChar[end] != ' ') {
                end++;
            } else if (end == strChar.length || strChar[end] == ' ') {
                reverse(strChar, begin, end - 1);
                begin = ++end;
            }
        }
        return strChar;
    }
}

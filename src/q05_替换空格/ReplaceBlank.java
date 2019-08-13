package q05_替换空格;

public class ReplaceBlank {
    public static void main(String[] args) {
        test("hello world");
        test(" hello world");
        test("helloworld ");
        test("hello  world");
        test(null);
        test("");
        test(" ");
        test("helloworld");
        test("     ");
    }

    private static String replaceWithSB(String str) {
        if (str == null || str.length() < 0)
            return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    private static String replaceWithString(String str) {
        if (str == null || str.length() < 0) {
            return null;
        }
        char[] strChar = str.toCharArray();
        int count = 0;
        for (int i = 0; i < strChar.length; i++) {
            if (strChar[i] == ' ') {
                count++;
            }
        }
        char[] newStr = new char[strChar.length + 2 * count];
        int oldPtr = str.length() - 1;
        int newPtr = newStr.length - 1;
        while (oldPtr != newPtr) {
            while (strChar[oldPtr] != ' ') {
                newStr[newPtr] = strChar[oldPtr];
                newPtr--;
                oldPtr--;
            }
            newStr[newPtr] = '%';
            newStr[newPtr - 1] = '0';
            newStr[newPtr - 2] = '2';
            newPtr = newPtr - 3;
            oldPtr--;
        }
        for (int i = newPtr; i >= 0; i--) {
            newStr[i] = strChar[i];
        }
        return new String(newStr);
    }

    private static void test(String str) {
        System.out.println("原数组：" + str);
        System.out.println("替换后：" + replaceWithSB(str));
        System.out.println("-------------");
    }
}

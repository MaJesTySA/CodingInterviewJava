package q20_表示数值的字符串;

public class NumericStrings {

    private static int pos = 0;

    public static void main(String[] args) {
        Test("Test1", "100", true);
        Test("Test2", "123.45e+6", true);
        Test("Test3", "+500", true);
        Test("Test4", "5e2", true);
        Test("Test5", "3.1416", true);
        Test("Test6", "600.", true);
        Test("Test7", "-.123", true);
        Test("Test8", "-1E-16", true);
        Test("Test9", "1.79769313486232E+308", true);
        Test("Test10", "12e", false);
        Test("Test11", "1a3.14", false);
        Test("Test12", "1+23", false);
        Test("Test13", "1.2.3", false);
        Test("Test14", "+-5", false);
        Test("Test15", "12e+5.4", false);
        Test("Test16", ".", false);
        Test("Test17", ".e1", false);
        Test("Test18", "e1", false);
        Test("Test19", "+.", false);
        Test("Test20", "", false);
        Test("Test21", null, false);

    }

    private static boolean isNumeric(String str) {
        pos = 0;
        if (str == null || str.length() <= 0)
            return false;
        boolean numeric = scanInteger(str);
        if (pos < str.length() && str.charAt(pos) == '.') {
            ++pos;
            /*
            小数点的前面可以没有整数部分，比如.123等于0.123，也就是说numeric为false时，整体也要为真
            小数点的后面可以没有数字，比如233.等于233.0，此时前面为false。
            当然也可以前后都有数字，都为true。所以是||的关系。
            */
            numeric = scanUnsignedInt(str) || numeric;
        }
        if (pos < str.length() && (str.charAt(pos) == 'e' || str.charAt(pos) == 'E')) {
            ++pos;
            /*
            指数的前面没有数字时，整个字符串不能表示数字，比如.e1、e1
            指数的后面没有整数时，整个字符串不能表示数字，比如12e、12e+5.4
             */
            numeric = numeric && scanInteger(str);
        }
        return numeric && pos == str.length();
    }

    private static boolean scanInteger(String str) {
        // +、- 不是必须，遇到+、-就向后移，检查是否有数字
        if (pos < str.length() && (str.charAt(pos) == '+' || str.charAt(pos) == '-'))
            ++pos;
        return scanUnsignedInt(str);
    }


    private static boolean scanUnsignedInt(String str) {
        int tempPos = pos;
        while (pos < str.length() && str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
            ++pos;
        }
        //有数字则返回true，没数字则返回false
        return pos > tempPos;
    }

    private static void Test(String name, String str, boolean isNum) {
        System.out.printf("%s begins ...", name);
        if (isNumeric(str) == isNum)
            System.out.println("Passed.");
        else
            System.out.println("Failed");
    }
}

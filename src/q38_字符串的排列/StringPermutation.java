package q38_字符串的排列;

public class StringPermutation {
    public static void main(String[] args) {
        //permutation("abc");
        System.out.println(1 + 1 >> 1);
    }

    private static void permutation(String string) {
        if (string == null)
            return;
        char[] stringChar = string.toCharArray();
        permutation(stringChar, 0);
    }

    private static void permutation(char[] string, int begin) {
        if (begin == string.length)
            System.out.println(string);
        else {
            for (int pos = begin; pos < string.length; pos++) {
                //先跟自己交换，算一种
                char temp = string[pos];
                string[pos] = string[begin];
                string[begin] = temp;
                permutation(string, begin + 1);
                //再跟下一个字符交换
                temp = string[pos];
                string[pos] = string[begin];
                string[begin] = temp;
            }
        }
    }

}

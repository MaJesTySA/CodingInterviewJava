package q17_打印1到最大的n位数;

public class Print1ToMaxOfNDigits {
    public static void main(String[] args) {
        print(2);
    }

    private static void print(int n) {
        int num = 1;
        while (n > 0) {
            num *= 10;
            n--;
        }
        for (int i = 0; i < num; i++) {
            System.out.print(i + "\t");
        }
    }
}

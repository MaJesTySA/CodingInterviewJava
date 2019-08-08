package q10_斐波那契;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibWithRecur(10));
        System.out.println(fibWithWhile(10));
    }
    private static int fibWithRecur(int n){
        if (n<=0)
            return 0;
        if (n==1)
            return 1;
        return fibWithRecur(n-1)+fibWithRecur(n-2);
    }
    private static int fibWithWhile(int n){
        if (n<=0)
            return 0;
        if (n==1)
            return 1;
        int fibNMinusOne=1;
        int fibNMinusTwo=0;
        int fibN=0;
        for (int i = 2; i <= n; i++) {
            fibN=fibNMinusOne+fibNMinusTwo;
            fibNMinusTwo=fibNMinusOne;
            fibNMinusOne=fibN;
        }
        return fibN;
    }
}

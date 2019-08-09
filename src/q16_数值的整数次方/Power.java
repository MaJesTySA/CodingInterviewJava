package q16_数值的整数次方;

public class Power {
    public static void main(String[] args) {
        test("底数、指数都为正数", 2, 3, 8, false);
        test("底数为负数、指数为正数", -2, 3, -8, false);
        test("指数为负数", 2, -3, 0.125, false);
        test("指数为0", 2, 0, 1, false);
        test("底数、指数都为0", 0, 0, 1, false);
        test("底数为0、指数为正数", 0, 4, 0, false);
        test("底数为0、指数为负数", 0, -4, 0, true);
    }

    private static boolean invalidInput;

    private static double pow(double base, int exp) {
        invalidInput = false;
        if (base == 0.0 && exp < 0) {
            invalidInput = true;
            return 0.0;
        }
        if (exp < 0) {
            double result = power(base, -exp);
            return 1.0 / result;
        }
        return power(base, exp);
    }

    private static double power(double base, int exp) {
        if (exp == 0)
            return 1;
        if (exp == 1)
            return base;
        double result = power(base, exp >> 1);
        result *= result;
        //如果exp是奇数
        if ((exp & 0x1) == 1)
            result *= base;
        return result;
    }

    private static void test(String name, double base, int exp, double expectedRes, boolean expectedFlag) {
        System.out.println(name);
        double res = pow(base, exp);
        System.out.println("expected result = " + expectedRes + " result = " + res);
        System.out.println("expected flag = " + expectedFlag + " flag = " + invalidInput);
        System.out.println("===================================");
    }
}

package q15_二进制1的个数;

public class NumberOf1InBinary {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void test6() {
        System.out.print("测试数0x80000000，期待值为1\t");
        System.out.print("左移法: " + numberOfOneLeft(0x80000000L));
        System.out.println("\t减一法: " + numberOfOneMinus(0x80000000L));
    }

    private static void test5() {
        System.out.print("测试数0xFFFFFFFF，期待值为32\t");
        System.out.print("左移法: " + numberOfOneLeft(0xFFFFFFFFL));
        System.out.println("\t减一法: " + numberOfOneMinus(0xFFFFFFFFL));
    }

    private static void test4() {
        System.out.print("测试数0x7FFFFFFF，期待值为31\t");
        System.out.print("左移法: " + numberOfOneLeft(0x7FFFFFFFL));
        System.out.println("\t减一法: " + numberOfOneMinus(0x7FFFFFFFL));
    }

    private static void test3() {
        System.out.print("测试数10，期待值为2\t");
        System.out.print("左移法: " + numberOfOneLeft(10L));
        System.out.println("\t减一法: " + numberOfOneMinus(10L));
    }

    private static void test2() {
        System.out.print("测试数1，期待值为1\t");
        System.out.print("左移法: " + numberOfOneLeft(1L));
        System.out.println("\t减一法: " + numberOfOneMinus(1L));
    }

    private static void test1() {
        System.out.print("测试数0，期待值为0\t");
        System.out.print("左移法: " + numberOfOneLeft(0L));
        System.out.println("\t减一法: " + numberOfOneMinus(0L));
    }

    private static int numberOfOneRight(long n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) > 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    private static int numberOfOneLeft(long n) {
        int count = 0;
        int flag = 1;
        //& 0xFFFF
        while (flag != 0) {
            if ((n & flag) > 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    private static int numberOfOneMinus(long n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}

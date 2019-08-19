package q49_丑数;

public class UglyNumber {
    public static void main(String[] args) {
        test(1, 1);
        test(2, 2);
        test(3, 3);
        test(4, 4);
        test(5, 5);
        test(6, 6);
        test(7, 8);
        test(8, 9);
        test(9, 10);
        test(10, 12);
        test(11, 15);
        test(1500, 859963392);
        test(0, 0);
    }

    private static boolean isUgly(int number){
        while (number % 2==0)
            number/=2;
        while (number % 3==0)
            number/=3;
        while (number % 5==0)
            number/=5;
        return number==1;
    }

    private static int getUglyNumber(int index){
        if (index<=0)
            return 0;
        int number=0;
        int uglyFound=0;
        while (uglyFound<index){
            ++number;
            if (isUgly(number))
                ++uglyFound;
        }
        return number;
    }

    private static int getUglyNumberLessTime(int index){
        if (index<=0)
            return 0;
        int[] uglyNumbers=new int[index];
        uglyNumbers[0]=1;
        int nextUglyIndex=1;
        int multiply2=0;
        int multiply3=0;
        int multiply5=0;
        while (nextUglyIndex<index){
            //下一个丑数，一定是前面某个丑数的2/3/5倍，最小的那个就是下一个。
            int min=Math.min(Math.min(uglyNumbers[multiply2]*2,uglyNumbers[multiply3]*3),
                    uglyNumbers[multiply5]*5);
            uglyNumbers[nextUglyIndex]=min;
            //丑数数组中存在一个数，在它前面的数的两倍均小于下一个丑数，找到这个数，避免对每一个丑数都*2。
            while (uglyNumbers[multiply2]*2<=uglyNumbers[nextUglyIndex])
                ++multiply2;
            while (uglyNumbers[multiply3]*3<=uglyNumbers[nextUglyIndex])
                ++multiply3;
            while (uglyNumbers[multiply5]*5<=uglyNumbers[nextUglyIndex])
                ++multiply5;
            ++nextUglyIndex;
        }
        return uglyNumbers[nextUglyIndex-1];
    }

    private static void test(int index,int expected) {
        if (getUglyNumberLessTime(index)==expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }
}

package q41_数据流中的中位数;

import java.util.TreeSet;

public class StreamMedian {
    public static void main(String[] args) {
        DynamicArray nums = new DynamicArray();
        nums.insert(5);
        System.out.println("[5]                " + nums.getMedian());
        nums.insert(2);
        System.out.println("[2,5]              " + nums.getMedian());
        nums.insert(3);
        System.out.println("[2,3,5]            " + nums.getMedian());
        nums.insert(4);
        System.out.println("[2,3,4,5]          " + nums.getMedian());
        nums.insert(1);
        System.out.println("[1,2,3,4,5]        " + nums.getMedian());
        nums.insert(6);
        System.out.println("[1,2,3,4,5,6]      " + nums.getMedian());
        nums.insert(7);
        System.out.println("[1,2,3,4,5,6,7]    " + nums.getMedian());
        nums.insert(0);
        System.out.println("[0,1,2,3,4,5,6,7]  " + nums.getMedian());
        nums.insert(8);
        System.out.println("[0,1,2,3,4,5,6,7,8]" + nums.getMedian());
    }
}

class DynamicArray {
    private TreeSet<Integer> min = new TreeSet<>();
    private TreeSet<Integer> max = new TreeSet<>();

    public void insert(int num) {
        //总数目是偶数，新数字插入最小堆
        if (((min.size() + max.size()) % 2 == 0)) {
            //但是如果插入的数字，比最大堆的数字还大
            if (max.size() > 0 && num < max.last()) {
                //取出当前最大堆最大值
                int maxLast = max.last();
                //最大堆移除当前最大值
                max.remove(max.last());
                //最大堆插入插入值
                max.add(num);
                //最小堆插入最大堆最大值
                min.add(maxLast);
                return;
            }
            min.add(num);
        } else {
            //插入的数字，大于最小堆的最小值
            if (min.size() > 0 && num > min.first()) {
                //取出最小堆的最小值
                int minFirst = min.first();
                //最小堆移除当前最小值
                min.remove(min.first());
                //最小堆插入当前值
                min.add(num);
                //最大堆插入最小堆最小值
                max.add(minFirst);
                return;
            }
            max.add(num);
        }
    }

    public double getMedian() {
        int size = min.size() + max.size();
        if (size == 0) {
            System.out.println("No numbers are available");
            return -1;
        }
        double median;
        if (size % 2 != 0)
            median = min.first();
        else
            median = (min.first() + max.last()) / 2.0;
        return median;
    }
}

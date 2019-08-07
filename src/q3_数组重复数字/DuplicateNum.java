package q3_数组重复数字;

import java.util.*;

public class DuplicateNum {
    public static void main(String[] args) {
        int[] arr={  2, 0, 2, 1, 4 };
        System.out.println(getDuplicateWithHash(arr));
    }

    /*
        空间复杂度 HashMpa O(N)，时间复杂度O(N)。
     */
    private static Set<Integer> getDuplicateWithHash(int[] arr){
        Set<Integer> result=new HashSet<>();
        if (arr==null || arr.length<0){
            return result;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<0 || arr[i]>arr.length-1)
                return result;
        }
        HashMap<Integer,Integer> numsMap=new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (numsMap.get(arr[i])==null){
                numsMap.put(arr[i],arr[i]);
            } else
                result.add(arr[i]);
        }
        return result;
    }

    /*
        空间复杂度O(1)，虽然有两重循环，但是时间复杂度是O(N)。
     */
    private static Set<Integer> getDuplicateWithLessSpace(int[] arr){
        Set<Integer> result=new HashSet<>();
        if (arr==null || arr.length<0){
            return result;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<0 || arr[i]>arr.length-1)
                return result;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i]!=i){
                if (arr[i]==arr[arr[i]]){
                    result.add(arr[i]);
                } else{
                    int temp=arr[i];
                    arr[i]=arr[temp];
                    arr[temp]=temp;
                }
            }
        }
        return result;
    }
}

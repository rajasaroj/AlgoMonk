package algomonk.geekforgeek;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *
 *
 * 23 find all pairs on integer array whose sum is equal to given number
 */
public class FindPairs {

    public static void main(String[] args) {
        //System.out.println(getPairsCount(new int[]{1,1,0,1,2}, 5, 2 ));
        //System.out.println(getPairsCount(new int[]{1,5,7,1}, 4, 6 ));
        //System.out.println(getPairsCount(new int[]{1,1,1,1}, 4, 2 ));

        int[] ar = {48,24,99,51,33,39,29,83,74,72,22,46,40,51,67,37,78,76,26,28,76,25,10,65,64,47,34,88,26,49,86,73,73,36,75,5,26,4,39,99,27,12,97,67,63,15,3,92,90};
        System.out.println(getPairsCount(ar, 49, 50 ));
        //System.out.println(factorial(3));
    }

    public static int getPairsCount(int[] arr, int n, int k) {
        // code here
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for (int i = 0; i < arr.length; i++)  {
            int res = k-arr[i];

            if (map.containsKey(res)) {
                count = count + map.get(res);
            }

            if (arr[i] == res) count--;

        }

        return count/2;
    }
}

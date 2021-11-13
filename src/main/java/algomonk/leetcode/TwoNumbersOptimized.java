package algomonk.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/ 2,7,11,15
public class TwoNumbersOptimized {

    public static void main(String[] args) {

        // int[] a = new int[] {3,2,95,4,-3};
        // int[] a = new int[] {2,7,11,15};
        int[] a = new int[] {3,3};
        //int[] a = new int[] {0, 4, 3, 0};
        //int a[] = new int[] {-3,4,3,90};
        //int a [] = new int[] {-1,-2,-3,-4,-5};
        // int a [] = new int[] {-18,12,3,0};


        int traget = 6;
        System.out.println(Arrays.toString(new TwoNumbersOptimized().twoSum(a, traget)));
    }


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]) && (i != map.get(target - nums[i])) ) {
                return new int[] {map.get(target - nums[i]),i};
            }
            map.put(nums[i], i);
        }

        return new int[]{0, 0};
    }

}

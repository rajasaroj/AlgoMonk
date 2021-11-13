package algomonk.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

// https://leetcode.com/problems/two-sum/ 2,7,11,15
public class TwoNumbers {

    public static void main(String[] args) {

         int[] a = new int[] {3,2,95,4,-3};
        // int[] a = new int[] {2,7,11,15};
        //int[] a = new int[] {3,3};
        //int[] a = new int[] {0, 4, 3, 0};
        //int a[] = new int[] {-3,4,3,90};
        //int a [] = new int[] {-1,-2,-3,-4,-5};
        // int a [] = new int[] {-18,12,3,0};


        int traget = 92;
        System.out.println(Arrays.toString(new TwoNumbers().twoSum(a, traget)));
    }


    public int[] twoSum(int[] nums, int target) {

        LinkedList<Integer> at = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new));

        int firstIdx =0;
        int secondIdx =0;

        for (int i = 0; i < nums.length; i++) {

            int currentValue = nums[i];
            int res;

            at.remove(i);
            at.add(i, null);

            if (target > 0) { res = target - currentValue; }
            else if (target < 0) { res = target - currentValue; }
            else { res = -currentValue;}


            if (at.contains(res)) {
                firstIdx = i;
                secondIdx = at.indexOf(res);
                break;
            } else {
                at.remove(i);
                at.add(i, currentValue);
            }
        }

        return new int[]{firstIdx, secondIdx};
    }



    /**
     *
     *
     * 11
     * [-5, 1, 0 , 6, 5, -6]
     *
     * if target is positive
     * check current num is less that target
     * res = subtract current num from target
     * check res in list
     *
     * -11
     * [-5, 1, 0 , 6, 5, -6]
     *
     * if target is neg
     * check current num is more that target
     * res = subtract target from  current num
     *
     */

}

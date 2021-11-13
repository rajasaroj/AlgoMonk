package algomonk.leetcode;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
// Search in a rotated sorted array 103
public class SearchInRotatedArray {

    static int count = 0;
    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2,-1};
        System.out.println(search(a, 4));
        System.out.println(count);
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length;
        return partitionSearch(nums,target, l, h);
    }

    public static int partitionSearch(int[] nums, int target, int l, int h) {
        count++;
        int v = -1;
        if (l < h) {
            int m = (l + h) / 2;

            if (nums[m] == target) {
                return m;
            } else {
               v = partitionSearch(nums, target, l, m);
                if (v == -1) v = partitionSearch(nums, target, m+1, h);
            }
        }
        return v;
    }
}

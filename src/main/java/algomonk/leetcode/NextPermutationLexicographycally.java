package algomonk.leetcode;

import java.util.*;

/**
 *
 * 19 Next Permutation
 * https://leetcode.com/problems/next-permutation/
 *
 * 1 3 5 4 2 -> 1 4 2 3 5
 *
 * [1, 3, 5, 2, 4]
 *
 * [1, 3, 5, 4, 2] after flip [1, 4, 5, 3, 2]
 * [1, 4, 2, 3, 5]
 *
 * [1, 4, 2, 5, 3]
 *
 *
 *
 * [1, 5, 4, 3, 2]
 * [2, 1, 3, 4, 5]
 * [2, 1, 3, 5, 4]
 *
 *
 *
 *
 * [6, 5, 3, 1, 4, 2]
 * [6, 5, 3, 2, 1, 4]
 * [6, 5, 3, 2, 4, 1]
 *
 *
 *
 *
 * [4, 1, 2, 3]
 *
 * [4, 1, 3, 2]
 * [4, 2, 1, 3]
 * [4, 2, 1, 3]
 *
 * iterate from back-1
 * check for index of i where a[i] < a[i+1] save it as first
 * check for index of i where a[i] > first save it in second
 * swap (first and second)
 *
 *
 * testcase 1
 * seq 1 = [1, 3, 5, 4, 2]
 *
 *       5
 *    3     4
 * 1           2
 *
 * next_sequence_2 = [1, 4, 2, 3, 5]
 * traverse from back and search for element a[i] < a[i+1]
 * (this means, that from that index a incline pattern is created)
 * [1, 3, 5, 4, 2]
 * a[i](3) < a[i+1](5)
 * save first=3
 *
 * traverse again from back and search for the a[i] > (first) previously found element
 * (this means the number greater than (first) will be somewhere at the decline of the pattern)
 * [1, 3, 5, 4, 2]
 * a[i] (4) > 3
 * second = 4
 *
 * swap first and second elements
 * [1, 4, 5, 3, 2]
 * reverse from i+1th index
 *
 * [1, 4, 2, 3, 5] == next_sequence_2
 *
 *
 *
 *
 *
 *
 *
 * [1, 4, 2, 3, 5]
 * next_sequence_3 =[1, 4, 2, 5, 3]
 * traverse from back and search for element a[i] < a[i+1]
 * (this means, that from that index a incline pattern is created)
 * [1, 4, 2, 3, 5]
 * a[i](3) < a[i+1](5)
 * save first=3
 *
 * traverse again from back and search for the a[i] > (first) previously found element
 * (this means the number greater than (first) will be somewhere at the decline of the pattern)
 * [1, 4, 2, 3, 5]
 * a[i] (5) > 3
 * second = 5
 *
 * swap first and second elements
 * [1, 4, 2, 5, 3]
 * i was at 3rd index
 * hence i+1=4th index
 * since array size is 4 then nothing else to reverse from i+1th index
 *
 * [1, 4, 2, 5, 3]  == next_sequence_3
 *
 *
 * [5,4,7,5,3,2]
 * 4,5
 * [5,5,7,4,3,2]
 * [5,5,2,3,4,7]
 *
 *
 *
 * [5,4,7,5,3,2] = i = 6-2 = 4
 * i=1
 * 4
 *
 * j=5
 * 5
 * [5,5,7,4,3,2]
 *
 *
 *
 * [5, 4, 7, 5, 2, 3]
 * [5, 4, 7, 5, 2, 3] ------------
 *
 *
 *
 * [5, 4, 7, 5, 3, 2]
 * [5, 4, 7, 5, 3, 2] ---------------------- [5, 5, 7, 4, 3, 2]
 *
 * rev [5,5,2,3,4,7]
 *
 * [5, 5, 2, 3, 4, 7]
 *
 *
 */
public class NextPermutationLexicographycally {

//    Permutation Code.
//    public static void main(String[] args) {
//
//        List<List<Integer>> r = new ArrayList<>();
//        permute(new Integer[]{5,4,7,5,3,2}, 0, r);
//
//        r.sort((o1, o2) -> {
//                    for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
//                        int c = o1.get(i).compareTo(o2.get(i));
//                        if (c != 0) {
//                            return c;
//                        }
//                    }
//                    return Integer.compare(o1.size(), o2.size());
//                }
//
//        );
//
//        for (int i = 0; i < r.size(); i++) {
//            System.out.println(r.get(i));
//        }
//
//    }
//
//    public static void permute(Integer[] arr, int k, List<List<Integer>> r ) {
//
//        for (int i = k; i < arr.length; i++) {
//            swap(arr, i, k);
//            permute(arr, k+1, r);
//            swap(arr,k,i);
//        }
//
//        if (k == arr.length-1) {
//            //System.out.println(Arrays.toString(arr));
//
//            r.add(Arrays.asList(arr.clone()));
//        }
//    }
//

    public static void swap(Integer[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        //int[] a = new int[] {1,2,3};
        //int[] a = new int[] {1, 3, 5, 4, 2};
        //int[] a = new int[] {2,1};
        Integer[] a = new Integer[] {5,4,7,5,3,2};
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }

    public static void nextPermutation(Integer[] nums) {

        int indexToReverseFrom = -1;

        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                indexToReverseFrom = i;
                break;
            }
        }

        if (indexToReverseFrom != -1) {

            for (int i = nums.length-1; i >= 0; i--) {
                if(nums[i] > nums[indexToReverseFrom]) {
                    swap(nums, i, indexToReverseFrom);
                    break;
                }
            }

            int c = nums.length;
            reverse(nums, indexToReverseFrom+1);
        } else {
            int c = nums.length;
            reverse(nums, 0);
        }

    }

    public static void reverse(Integer[] nums, int i) {
        int j = nums.length-1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

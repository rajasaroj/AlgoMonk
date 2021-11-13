package algomonk.leetcode;

import java.util.Arrays;


/**
 *  TODO :- need to check below most optimized leetcode solution
 *
 *  LEETCODE MOST OPTIMIZED SOLUTION FOR THIS PROBLEM
 *
 *  public int kthSmallest(int[][] matrix, int k) {
 *         int m = matrix.length, n = matrix[0].length;
 *
 *         int low = matrix[0][0], high = matrix[m-1][n-1];
 *
 *         while( low < high) {
 *             int mid = low + (high - low) / 2;
 *             int count = 0;
 *             int j = n-1;
 *             for(int i=0;i<m;i++) {
 *                 while(j >= 0 && matrix[i][j] > mid)
 *                     j--;
 *
 *                 count += (j+1);
 *             }
 *
 *             if(count < k)
 *                 low = mid+1;
 *
 *             else
 *                 high = mid;
 *         }
 *
 *         return low;
 *     }
 *
 *
 *
 */



// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthSmallestSortedMatrix {

    public static void main(String[] args) {
        int[][] a = new int[][] {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };

//        int[][] a = new int[][] {
//                {-5}
//        };

        int v = kthSmallestOptimized(a, 3);
        System.out.println(v);
       //System.out.println(Arrays.toString(b));
    }

    public static int kthSmallest(int[][] matrix, int k) {

        int[] merged = new int[0];

        for (int i = 0; i < matrix.length; i++) {
                int[] m = new int[merged.length + matrix[i].length];
                merge(m, merged, matrix[i]);
                merged = m;
                System.out.println(Arrays.toString(m));
        }

        return merged[k-1];
    }

    public static void merge(int arr[], int[] left, int[] right) {

        int i=0, j=0, k=0;
        while (i < left.length && j < right.length) {

            if(left[i] < right[j]) { arr[k++] = left[i++]; }
            else { arr[k++] = right[j++]; }

        }

        while (i < left.length) { arr[k++] = left[i++]; }
        while (j < right.length) { arr[k++] = right[j++]; }

    }



    // TODO :- need to check below most optimized leetcode solution
    // LEETCODE MOST OPTIMIZED SOLUTION FOR THIS PROBLEM

    public static int kthSmallestOptimized(int[][] matrix, int k) {

             int m = matrix.length, n = matrix[0].length;

             int low = matrix[0][0], high = matrix[m-1][n-1];

             while( low < high) {
                 int mid = low + (high - low) / 2;
                 int count = 0;
                 int j = n-1;
                 for(int i=0;i<m;i++) {
                     while(j >= 0 && matrix[i][j] > mid)
                         j--;

                     count += (j+1);
                 }

                 if(count < k)
                     low = mid+1;

                 else
                     high = mid;
             }

             return low;
    }



}

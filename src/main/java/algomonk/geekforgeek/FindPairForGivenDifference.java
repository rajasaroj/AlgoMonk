package algomonk.geekforgeek;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1
 * 110 find a pair with a given difference
 *
 */
public class FindPairForGivenDifference {

    public static void main(String[] args) {
        int[] a = {6290,9750,9553,857,1626,200,4,112,832,7357,4481,4886,3612,7191,2557,1372,7353,3698,3358,7625,4668,9704,7661,1068,7700,197,4312,5414,7742,6290,8755,4031,6039,4659,4887,4016,4858,1242,4128,2041,4951,4960,6926,4914,8502,5835,2637,5854,5884,5994,9830,551,5697,7491,7970,9748,4039,2281,5161,1780,8571,267,2162,961,4926,3401,4977,6135,994,5456,8176,5944,6767,1453,7209,5268,7287,6198,1121,3170,2191,7303,73,4240,4793,8042,3987,5183,6675,5500,3314,1597,5766,5475,2557,7043,8875,3885,3178,9869,5692,1353,2164,2458,9157,5725,7725,6444,1922,5198,5965,464,2500,6037,4703,3644,431,8690,8826,7105,541,2139,5053,2658,7613,7609,9701};

        System.out.println(findPair(a, a.length, 490));
    }

    public static boolean findPair(int arr[], int size, int n){
        //code
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < size; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < size; i++) {
            if (set.contains(n+arr[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean findPairOptimized(int arr[], int size, int n)
    {
        //code here.
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (set.contains(n+arr[i]) || set.contains(Math.abs(n-arr[i]))) {
                return true;
            } else {
                set.add(arr[i]);
            }
        }
        return false;
    }
}

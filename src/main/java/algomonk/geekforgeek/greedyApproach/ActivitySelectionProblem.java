package algomonk.geekforgeek.greedyApproach;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 238 Activity Selection Problem
 *
 * https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1#
 *
 *
 */
public class ActivitySelectionProblem {

    public static void main(String[] args) {
        //int start[] = {1,3,0,5,8,5};
        //int end[] =  {2,4,6,7,9,9};

        int start[] = {48,19,83,8,85,83,74,93,20,80,27,9,19,42,12,47,49,51,13,44,47,21,31,80,84,7,5,93};
        int end[] =  {116,107,119,33,108,113,114,100,77,99,50,32,122,78,14,66,56,80,56,130,119,23,63,100,126,18,54,129};

        maxMeetings(start, end, start.length);

    }

    public static int maxMeetings(int start[], int end[], int n) {

        int previous = 0;
        int count = 0;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = start[i];
            pair[i][1] = end[i];
        }

        Arrays.sort(pair, Comparator.comparingInt(x -> x[1]));


        for (int i = 0; i < pair.length; i++) {

            if (previous < pair[i][0]) {
                count++;
                previous = pair[i][1];
            }
        }

        return count;
    }


}

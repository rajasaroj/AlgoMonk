package algomonk.geekforgeek;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndLastOccurence {
    public static void main(String[] args) {

        long[] at = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };

        System.out.println(find(at,  at.length, 1));
    }

    static ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        long firstOcc = -1;
        long lastOcc = -1;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == x) {
                if (firstOcc == -1 ) {
                    lastOcc = firstOcc = i;
                } else {
                   lastOcc = i;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(firstOcc, lastOcc));
    }
}

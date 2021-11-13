package algomonk.leetcode;

public class BinarySearch {

    public static boolean binarySearch(int a[], int numToFind) {
        int l = 0;
        int h = a.length;

        while (l < h) {
            int m = (l + h)/2;

            if ( numToFind < a[m] ) {
                h = m;
            } else if ( numToFind > a[m] ) {
                l = m+1;
            } else {
                return true;
            }
        }

        return false;
    }
}

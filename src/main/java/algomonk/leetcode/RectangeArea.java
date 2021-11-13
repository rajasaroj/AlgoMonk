package algomonk.leetcode;


/**
 *
 *
 *
 * -2
 * -2
 * 2
 * 2
 * -1
 * -1
 * 1
 * 1
 *
 * -5
 * -5
 * 0
 * 3
 * -3
 * -3
 * 3
 * 3
 *
 *
 */

public class RectangeArea {
    public static void main(String[] args) {
        // int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        //int ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -1, by1 = -1, bx2 = 1, by2 = 1;
        // int ax1 = 0, ay1 = 0, ax2 = 0, ay2 = 0, bx1 = -1, by1 = -1, bx2 = 1, by2 = 1; 4
        //int ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = 1, by1 = -3, bx2 = 3, by2 = -1; = 19

        int ax1 = -5, ay1 = -5, ax2 = 0, ay2 = 3, bx1 = -3, by1 = -3, bx2 = 3, by2 = 3;
        System.out.println( computeArea(ax1,  ay1,  ax2,  ay2,  bx1,  by1,  bx2,  by2));
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int pl = Math.abs(ax1 - ax2);
        int ph = Math.abs(ay1 - ay2);

        int rl = Math.abs(bx1 - bx2);
        int rh = Math.abs(by1 - by2);

        int nx = calculateXLen(ax1,  ay1,  ax2,  ay2,  bx1,  by1,  bx2,  by2);
        int ny = calculateYLen(ax1,  ay1,  ax2,  ay2,  bx1,  by1,  bx2,  by2);


        if (check(ax1, ay1, ax2, ay2)) {
            return Math.abs( rl * rh);
        } else if (check(bx1, by1, bx2, by2)) {
            return Math.abs( pl * ph);
        } else if (checkUnderlap( ax1 ,  ay1 ,  ax2 ,  ay2 ,   bx1 ,  by1 ,  bx2 ,  by2 )) {
            return Math.abs(Math.max(rl,pl) * Math.max(rh, ph));
        }


        if (checkOverlap(ax1,  ay1,  ax2,  ay2,  bx1,  by1,  bx2,  by2)) {
                return (Math.abs( pl * ph) + Math.abs(rl * rh)) - (nx * ny);
        }

        return Math.abs( pl * ph) + Math.abs(rl * rh);
    }

    public static boolean check(int x1, int y1, int x2, int y2) {
        return x1 ==0 && x2 ==0 && y1 == 0 && y2 ==0;
    }

    public static boolean checkOverlap(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return (by2 > ay1 && by1 < ay2) && (bx1 < ax2 && bx2 > ax1);
    }

    public static boolean checkUnderlap(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return ((bx2 <= ax2 && by2 <= ay2 && bx1 >= ax1 && by1 >= ay1)) || ((bx2 >= ax2 && by2 >= ay2 && bx1 <= ax1 && by1 <= ay1));
    }

    public static int calculateXLen(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int x = 0;

        if (bx2 >= ax2 && bx1 <= ax1) {
            x = (ax2-ax1);
        } else if (bx2 >= ax2) {
            x = ax2-bx1;
        } else if (bx2 <= ax2 && bx1 >= ax1) {
            x = bx2-bx1;
        } else if (bx2 <= ax2) {
            x = bx2 - ax1;
        }

        return x;
    }

    public static int calculateYLen(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int y = 0;


        if (by2 >= ay2 && by1 <= ay1) {
            y = ay2-ay1;
        } else if (by2 >= ay2) {
            y = ay2 - by1;
        } else if (by2 <= ay2 && by1 >= ay1) {
            y = by2 - by1;
        } else if (by2 <= ay2) {
            y = by2 - ay1;
        }

        return y;
    }
}

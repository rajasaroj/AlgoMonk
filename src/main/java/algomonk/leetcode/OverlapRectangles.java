package algomonk.leetcode;

public class OverlapRectangles {

    public static void main(String[] args) {
//        int[] rec1 = new int[]{0,0,2,2};
//        int[] rec2 = new int[]{1,1,3,3};
//
//        int[] rec1 = new int[]{0,0,2,2};
//        int[] rec2 = new int[]{1,1,3,3};

        int[] rec1 = new int[]{0,0,1,1};
        int[] rec2 = new int[]{2,2,3,3};

        System.out.println(new OverlapRectangles().isRectangleOverlap(rec1, rec2));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int ax1 = rec1[0];
        int ay1 = rec1[1];
        int ax2 = rec1[2];
        int ay2 = rec1[3];

        int bx1 = rec2[0];
        int by1 = rec2[1];
        int bx2 = rec2[2];
        int by2 = rec2[3];

        // boolean b = (rec2[3] > rec1[1] && rec2[1] < rec1[3]) && (rec2[0] < rec1[2] && rec2[2] > rec1[0]);

        return checkOverlap(ax1,  ay1,  ax2,  ay2,  bx1,  by1,  bx2,  by2);
    }

    public static boolean checkOverlap(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return (by2 > ay1 && by1 < ay2) && (bx1 < ax2 && bx2 > ax1);
    }
}

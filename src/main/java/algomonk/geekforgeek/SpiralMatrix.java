package algomonk.geekforgeek;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 44 Spiral traversal on a Matrix
 * https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
 * https://leetcode.com/problems/spiral-matrix/submissions/
 *
 * POC
 *
 * 00 01 02 03 04
 * 05 06 07 08 09
 * 10 11 12 13 14
 * 15 16 17 18 19
 * 20 21 22 23 24
 *
 * dir = 0
 *
 * up=0
 * down=r-1 = 2
 * left=0
 * right=c-1 = 2
 *
 * while(up <= down && left <= right)
 *
 * dir==0
 * iterate i till left -> right // [0,1,2,3,4]
 * ++up up=1
 * dir=1
 *
 * dir==1
 * iterate i till up -> down // [0,1,2,3,4,9,14,19,24]
 * --right=1
 * dir=2
 *
 * dir==2
 * iterate till right -> left // [0,1,2,3,4,9,14,19,24,23,22,21,20,15,10,05]  // Reverify the code and rely on the code its absolutely correct, this eg might be fuzzy
 * --down=1
 * dir=3
 *
 * dir==3
 * iterate till down->up // [0,1,2,3,4,9,14,19,24,23,22,21,20,23,]
 * left++ = 1
 *
 * dir=0
 *
 */
public class SpiralMatrix {

    public static void main(String[] args) {

        int r = 4, c = 4;
        int matrix[][] = {{1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15,16}};

        System.out.println(spirallyTraverse(matrix,r,c));
    }

    static ArrayList<Integer> spirallyTraverse(int matrix[][],int r, int c)
    {
        ArrayList<Integer> lst = new ArrayList<>();
        int up = 0;
        int down = r-1;
        int left = 0;
        int right = c-1;
        int dir=0;
        
        while (left <= right && up <= down) {
            
            if (dir == 0) {

                for (int i = left; i <= right; i++) {
                    lst.add(matrix[up][i]);
                }

                up++;
                dir++;
            } else if (dir == 1) {

                for (int i = up; i <= down; i++) {
                    lst.add(matrix[i][right]);
                }
                right--;
                dir++;
            } else if (dir == 2) {

                for (int i = right; i >= left; i--) {
                    lst.add(matrix[down][i]);
                }

                down--;
                dir++;
            } else if (dir == 3) {

                for (int i = down; i >= up; i--) {
                    lst.add(matrix[i][left]);
                }
                left++;
                dir=0;
            }
            
        }

        return lst;
    }
}

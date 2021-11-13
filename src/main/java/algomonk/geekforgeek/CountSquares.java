package algomonk.geekforgeek;

public class CountSquares {
    public static void main(String[] args) {
        System.out.println(countSquares(9));
    }

    static int countSquares(int N) {
        // code here
        int count = 0;
        for (int i = 1; i*i < N; i++) {
            count++;
        }
        return count;
    }
}

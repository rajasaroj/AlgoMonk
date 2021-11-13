package algomonk.leetcode;

public class Sqrt {
    public static void main(String[] args) {

        int x = 2147395600;
        System.out.println(new Sqrt().mySqrt(x));
    }

    public int mySqrt(int x) {

        long a = 0;

        while ((a*a) <= x) {
            a++;
        }


        return (int) --a;
    }
}

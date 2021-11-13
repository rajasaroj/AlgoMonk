package algomonk.geekforgeek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 27 Find factorial of a large number
 *
 * https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1#
 */
public class FactorialOfLargeNumber {
    public static void main(String[] args) {
        System.out.println(factorial2(40));
//       List<Integer> at =  multpily(1, Collections.singletonList(1));
//        List<Integer> ab =  multpily(2, at);
//        List<Integer> ac =  multpily(3, ab);
//        List<Integer> ad =  multpily(4, ac);

    }

    public static ArrayList<Integer> factorial2(int N){


        List<Integer> at = Collections.singletonList(1);
        for (int i = 1; i <= N; i++) {
            at = multpily(i, at);
        }
        return (ArrayList<Integer>) at;
    }

    public static List<Integer> multpily(int multiplier, List<Integer> at) {

        int carry = 0;
        List<Integer> s = new ArrayList<>();
        for (int i = at.size()-1; i >=0 ; i--) {
             int mul = carry + (at.get(i) * multiplier);

             int rem = mul % 10;



             s.add(rem);
             carry = mul / 10;
        }

        while (carry != 0) {
            s.add(carry % 10);
            carry = carry / 10;
        }

        Collections.reverse(s);
        System.out.println("mul: " +multiplier);
        s.forEach(System.out::print);
        System.out.println();


        return s;
    }
}

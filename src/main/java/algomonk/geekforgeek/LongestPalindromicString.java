package algomonk.geekforgeek;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

/**
 *
 * 64 Find Longest Recurring Subsequence in String
 *
 * https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1#
 */
public class LongestPalindromicString {

    public static void main(String[] args) {
        //String S = "rfkqyuqfjkxy";
        String S = "aaaabbaaMaaadedaaaMeeee";
        //String S = "owo";
        String g = longestPalin(S);
        System.out.println(g);

    }

    static String longestPalin(String S){
        // code here
        String ans = slider(S);
        if (ans.length() > 0)
            return ans;

        return String.valueOf(S.charAt(0));
    }

    public static String slider(String s) {
        AtomicInteger max = new AtomicInteger();
        AtomicReference<String> longestPalinString = new AtomicReference<>("");
        IntStream.range(2, s.length()+1)
                .peek(x -> System.out.println("Printing window of: "+ x))
                .forEach(x -> {
            for (int i = x; i <= s.length(); i++) {
                String g = s.substring(i-x, i);
                if (g.charAt(0) == g.charAt(g.length()-1)) {
                    if (reverse(g) && max.get() < g.length()) {
                        max.set(g.length());
                        longestPalinString.set(g);
                    }
                }

                System.out.println(g);
            }
        });

        return longestPalinString.get();
    }

    public static boolean reverse(String s) {
        int size = s.length();
        for (int i = 0; i <= size/2; i++) {
            if (s.charAt(i) != s.charAt(size-i-1)) {
                return false;
            }
        }
        return true;
    }
}



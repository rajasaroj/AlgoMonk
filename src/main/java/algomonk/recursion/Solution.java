package algomonk.recursion;


import java.util.*;

/**
 *
 * "ab"
 * "eidbaooo"
 * "ab"
 * "eidboaoo"
 *
 *
 */
class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.checkInclusion("bc", "eidbaooo");
//
//        String r = "raja";
//
//        int[] c = new int[26];
//        for (int i = 0; i < r.length(); i++) {
//            c[r.charAt(i) - 'a']++;
//        }
//
        System.out.println(b);

    }

    public boolean checkInclusion(String s1, String s2) {

        if (s2.length() < s1.length()) return false;
        return initMap(s1, s2);
    }



    static boolean initMap(String s1, String s2) {

        int[] s1set = new int[26];


        for (int j = 0; j < s1.length(); j++) {
            s1set[s1.charAt(j) - 'a']++;
        }

        for (int i = 0; i <= (s2.length() - s1.length()) ; i++) {

            int[] s2set = new int[26];

            for (int j = 0; j < s1.length(); j++) {
                s2set[s2.charAt(i+j) - 'a']++;
            }

            if (matches(s1set, s2set)) { return true; }

        }
      return false;
    }

    static boolean matches(int[] s1set, int[] s2set) {
       return Arrays.equals(s1set, s2set);
    }

}

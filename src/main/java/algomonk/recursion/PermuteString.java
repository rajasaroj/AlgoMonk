package algomonk.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermuteString {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkInclusion("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef",
                "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"));

    }

    public boolean checkInclusion(String s1, String s2) {

        if (s2.length() < s1.length()) return false;
        return permute(s1, 0, s2);
    }

    static boolean permute(String str, int index, String s2) {
        boolean status = false;
        if(str.length() == index) return false;

        for (int i = index; i < str.length(); i++) {

            String nstr = swap(str, i, index);
            if(s2.contains(nstr)) return true;


            if (status) {
                return true;
            } else {
                status = permute(nstr, index+1, s2);
            }

        }
        return status;
    }

    static String swap(String str, int i, int j) {
        StringBuilder nstr = new StringBuilder(str);
        nstr.setCharAt(i, str.charAt(j));
        nstr.setCharAt(j, str.charAt(i));
        return nstr.toString();
    }
}

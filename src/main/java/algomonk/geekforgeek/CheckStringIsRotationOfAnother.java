package algomonk.geekforgeek;

// Write a Code to check whether one string is a rotation of another
public class CheckStringIsRotationOfAnother {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "bcdea";

        System.out.println(check(str1, str2));
    }

    /**
     * size = str2
     *
     * a != e   i=0 j=0 (j++)
     * a == a   i=0 j=1 (matched i++, j++ % size)
     * b == b   i=1 j=2 (matched i++, j++ % size)
     * c == c   i=2 j=3 (matched i++, j++ % size)
     * d == d   i=3 j=4 (matched i++, j++ % size)
     * e == d   i=4 j=0 (matched i++, j++ % size)
     *
     *
     *
     *
     *
     * @param str1, str2
     * @return
     */
    public static boolean check(String str1, String str2) {
        boolean doesMatched = false;
        int str2Len = str2.length();
        int j=0;
        for (int i = 0; i < str1.length(); ) {
            if (str1.charAt(i) == str2.charAt( j++ % str2Len )) {
                doesMatched = true;
                i++;
            }
            else if (doesMatched) return false;
        }
        return doesMatched;
    }
}

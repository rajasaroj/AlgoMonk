package algomonk.geekforgeek;

public class PalindromeString {

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdedcba"));
    }

    public static int isPalindrome(String str) {
        int size = str.length();
        int temp = 1;
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(size - i - 1)) { temp = 0; }
        }
        return temp;
    }
}

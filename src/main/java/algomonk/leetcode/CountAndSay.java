package algomonk.leetcode;

// 62 https://leetcode.com/problems/count-and-say/submissions/
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {

        String op = "1";

        for (int i = 1; i < n; i++) {
            op = checker(op);
        }

        return op;
    }

    public static String checker(String str) {

       StringBuilder built = new StringBuilder();

        for (int i = 0; i < str.length(); ) {

            int count = 1;
            int j = i+1;

            for (; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }

            // form string
            built.append(count).append(str.charAt(i));
            count = 0;
            i=j;
        }

        return built.toString();
    }
}

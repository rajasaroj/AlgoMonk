package algomonk.geekforgeek;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidStringShuffle {
    public static void main(String[] args) {
        System.out.println(check("sdfsd", "sd"));
        System.out.println(check("abcd", "abce"));
        System.out.println(check("aabb", "baba"));
        System.out.println(check("apple", "ppale"));
        System.out.println(check("a", "b"));
    }

    public static boolean check(String s1, String s2) {

        Map<Object, Long> ms1 = s1.chars()
                .mapToObj(Character::toChars)
                .map(String::valueOf)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        Map<Object, Long> ms2 = s2.chars()
                .mapToObj(Character::toChars)
                .map(String::valueOf)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        return ms1.equals(ms2);
    }
}

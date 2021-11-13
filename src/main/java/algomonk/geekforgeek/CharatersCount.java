package algomonk.geekforgeek;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CharatersCount {

    public static void main(String[] args) {
        counter("hhello");
        //System.out.println( String.valueOf("e".length()) );
    }

    public static void counter(String str) {
     /*   System.out.println(str.chars()
                .mapToObj(Character::toChars)
                .map(String::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));*/

        System.out.println(str.chars()
                .mapToObj(Character::toChars)
                .map(String::valueOf)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.reducing((x,y) -> String.valueOf(x.length() + y.length())  // Note this reducing fuction will only get called when there are multiple element in single group for eg h and l in string "hhello"
                        )
                )));
    }
}

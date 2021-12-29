package algomonk.hackerRank;

import java.util.*;
import java.util.stream.*;

public class EfficientJanitor {

    public static void main(String[] args) {
        solution(Stream.of(1.01, 1.99, 2.5, 1.3 ,1.01).collect(Collectors.toList()));
    }

    public static void solution(List<Double> lst) {

        int trip = 0;
        int leftPointer = 0;
        lst.sort(Comparator.naturalOrder());

        for (int i = lst.size()-1; i >=0 ; i--) {

            if (lst.get(i) > 1.99) {
                trip++;
            } else {

                if ( (lst.get(leftPointer) + lst.get(i)) <= 3.0 ) {
                    leftPointer++;
                }

                trip++;
            }

            if (leftPointer >= i) {
                break;
            }
        }

        System.out.println(trip);
    }
}

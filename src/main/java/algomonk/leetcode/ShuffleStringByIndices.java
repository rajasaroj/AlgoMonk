package algomonk.leetcode;

import java.util.Collections;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShuffleStringByIndices {
    public static void main(String[] args) {
        System.out.println( restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3} ));
    }

    public static String restoreString(String s, int[] indices) {
        TreeMap<Integer, Character> treeMap = new TreeMap<>();

        for (int i = 0; i < indices.length; i++) {
            treeMap.put(indices[i], s.charAt(i));
        }

        return treeMap.values().stream().map(String::valueOf).collect(Collectors.joining());
    }
}

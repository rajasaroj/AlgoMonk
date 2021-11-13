package algomonk.geekforgeek;

import java.util.ArrayList;
import java.util.List;

public class ValueEqualToIndexArray {

    public static void main(String[] args) {
        int[] a = {5,2};
        System.out.println(valueEqualToIndex(a));
    }

    static ArrayList<Integer> valueEqualToIndex(int arr[]) {
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) if (i+1 == arr[i]) lst.add(arr[i]);
        return lst;
    }
}

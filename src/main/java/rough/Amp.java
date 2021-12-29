package rough;

import java.util.Arrays;

public class Amp {

    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5,6,7,8};
    }

    public static void print(int arr[], int k) {


        for (int i = 0; i < arr.length; i++) {

            if (i % k == 0) {
                System.out.println("\n");
            }

        }
    }

    public static void createBlock() {

    }
}

package algomonk.geekforgeek;

public class MaxAndMin {
    public static void main(String[] args) {
        int[] arr = new int[] {-100,100,1,2,3,4,5,6,7,8, -1, -100};
        maxAndMin(arr);
    }

    public static void maxAndMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println(max);
        System.out.println(min);
    }
}

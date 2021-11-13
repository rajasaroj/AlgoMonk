package algomonk.sorts;

import java.util.Arrays;

public class TwoWayMergeSort {


    public static void main(String[] args) {
        Integer[] a = {9,3,4,2, 5,6,7,8,1};

        int window = 2;
        int i;

        while (window <= a.length) {
            System.out.println("window size: "+ window );
            i=0;

            for (int j = 0; j < a.length; j++) {
                int startoffset = i;
                int endOffset= window+(startoffset-1);

                if(endOffset >= a.length) {
                    break;
                };

                mergeDriver(a,startoffset, endOffset, window);
                System.out.println();
                i = i+window;
            }
            window*=2;
        }

        if (a.length > 3 && a.length%2 !=0 && a[a.length-1] < a[a.length-2]) {
            Integer[] l = new Integer[] {a[a.length-1]};

            System.out.println("Final Sort");
            Arrays.stream(merge(a, l)).limit(a.length).forEach(System.out::println);

        }
    }


    public static Integer[] mergeDriver(Integer[] a, int start, int end, int window) {

        int mid = (start+end)/2;
        System.out.print(a[start] + "," + a[end] + " mid: "+ a[mid]);

        Integer[] l = new Integer[window/2];
        Integer[] r = new Integer[window/2];

        for (int i = 0; i < window/2; i++) {
            l[i] = a[start+i];
            r[i] = a[mid+i+1];
            System.out.println();
            Arrays.stream(l).forEach(x -> System.out.print("L: "+ x + ", "));
            Arrays.stream(r).forEach(x -> System.out.print("R: "+ x + ", "));

        }

        System.out.println();
        Integer[] c =  merge(l,r);

        return adjustArr(c, a, window, mid, start);
    }

    public static Integer[] adjustArr(Integer[] c , Integer a[], int window, int mid, int start) {
        int c_mid = (c.length/2) -1;

        for (int i = 0; i < window/2; i++) {
            a[start+i] = c[i];
            a[mid+i+1] = c[c_mid + i +1];
        }

        Arrays.stream(a).forEach(x -> System.out.print("OP: "+ x + ", "));
        return a;
    }

    public static Integer[] merge(Integer[] a, Integer[] b) {

        int i=0;
        int j=0;
        int k=0;
        Integer[] c = new Integer[a.length + b.length];

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < a.length) {
            c[k++] = a[i++];
        }

        while (j < b.length) {
            c[k++] = b[j++];
        }

        return c;
    }
}



//
//        System.out.println("After Jack");
//                Arrays.stream(L).forEach(System.out::print);
//                System.out.println();
//                Arrays.stream(R).forEach(System.out::print);
//                System.out.println();
//                System.out.println(Arrays.toString(arr));
//                System.out.println("------");
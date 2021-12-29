package zombie;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/task-scheduler/
 */
public class Solver {
    public static void main(String[] args) {
        PriorityQueue<Long> taskTree = new PriorityQueue<>(Comparator.reverseOrder());
        taskTree.addAll(Stream.of('a', 'a', 'a', 'b', 'b', 'b')
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values());


        int n = 2;

        int result =0;
        while (!taskTree.isEmpty()) {
            int time = 0;
            List<Long> lst = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                Long val = taskTree.poll();
                if (val != null && val != 0) {
                    if (val-1 != 0) lst.add(val-1);
                    time++;
                }
            }

            taskTree.addAll(lst);
            result += (taskTree.isEmpty()) ? time : n+1;
        }

        System.out.println(result);












/*        List<Long> lst = new ArrayList<>(Stream.of('a', 'a', 'a', 'b', 'b', 'b')
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values());

       Collections.sort(lst, Comparator.reverseOrder());
        lst.add(0L);*/


/*        int idle = -1;

        List<Integer> task = new ArrayList<>();

        while (!lst.isEmpty()) {

            int n = 2;

            for (int i = 0; i < lst.size(); i++) {

                if (lst.get(i) == 0) {
                    lst.remove(0L);
                } else {

                }
            }
        }
        */



    }
}

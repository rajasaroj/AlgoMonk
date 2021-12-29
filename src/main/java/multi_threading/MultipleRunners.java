package multi_threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Creating 5 worker threads to perform sqr operation
 * using
 * ExecutorService -> for creating thread pool
 * Future -> for encapsulating callable task
 *
 */
public class MultipleRunners {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Integer>> integers =new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            integers.add(executorService.submit(new MyThread(i)));
        }

        integers.forEach(x -> {
            try {
                System.out.println(x.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}

class MyThread implements Callable<Integer> {

    int number;

    MyThread(int number) {
        this.number = number;
    }

    @Override
    public Integer call() {
        return number*number;
    }
}

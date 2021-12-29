package multi_threading;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JobMaker {

    /**
     *
     * 100 job unit
     * 10 batch
     * 10 worker threads
     *
     * task: multiplier
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int batchSize = 13;

        JobMaker j = new JobMaker();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Integer> data  = IntStream.range(1, 101).boxed().collect(Collectors.toList());

        int i=0;
        while (i < (data.size() / batchSize)) {
            System.out.println(data.subList(i*batchSize, (i+1)*batchSize));
            i++;
        }

        System.out.println(data.subList(i*batchSize, data.size()));




    }

    public void computeJobUsingJava8Way () {
        int batchSize = 10;

        JobMaker j = new JobMaker();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Integer> data  = IntStream.range(1, 101).boxed().collect(Collectors.toList());

        List<Future<List<Integer>>> lst = IntStream.range(0,(data.size() + batchSize-1)/batchSize)
                .mapToObj(i -> data.subList(batchSize * i, Math.min(data.size(),  (i+1)*batchSize)))
                .map(dataChunks -> executorService.submit(() -> j.batchDispatcher(dataChunks)))
                .collect(Collectors.toList());

        FutureTask fst = new FutureTask(() -> j.batchDispatcher(data));


        lst.forEach(x -> {
            try {
                System.out.println(x.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private synchronized List<Integer> batchDispatcher(List<Integer> lst) {
        return lst.stream().map(this::multiplier).collect(Collectors.toList());
    }

    private synchronized int multiplier(int x) {
        return x*x;
    }

}

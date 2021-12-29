package multi_threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Latch extends Thread {

    CountDownLatch latch;
    List<String> worker;
    AtomicInteger integer;

    Latch(CountDownLatch latch, List<String> worker, AtomicInteger integer) {
        this.latch = latch;
        this.worker = worker;
        this.integer = integer;
    }

    @Override
    public void run() {
        worker.add("worker "+ integer.incrementAndGet());
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        List<String> worker = new ArrayList<>();
        AtomicInteger integer = new AtomicInteger(0);

        IntStream.range(0, 5).mapToObj(x -> new Thread(new Latch(latch, worker, integer)) ).forEach(Thread::start);

        latch.await();
        worker.add("Job Done!!!");
        worker.forEach(System.out::println);

    }

    /*CountDownLatch latch;
    List<String> worker;

    public Latch(CountDownLatch latch, List<String> worker) {
        this.latch = latch;
        this.worker = worker;
    }

    @Override
    public void run() {
        worker.add("done");
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> worker = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(5);

         List<Thread> at = Stream.generate(() -> new Latch(latch, worker))
                .limit(5)
                .collect(Collectors.toList());

         at.forEach(Thread::start);

         latch.await();
         worker.add("latch completes");

        System.out.println(worker);


    }*/
}

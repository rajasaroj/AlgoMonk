package multi_threading;

public class ObjectLevelLock {
    public static void main(String[] args) {

        ObjectLevelLock l1 = new ObjectLevelLock();

        Thread t1 = new Thread(() -> {
            l1.m1();
            l1.m2();
        });

        Thread t2 = new Thread(() -> {
            l1.m1();
            l1.m2();
        });



        t1.start();
        t2.start();

    }

    public synchronized void m1() {
        System.out.println("m1 -> "+ Thread.currentThread().getName());
    }


    public synchronized void m2() {
        System.out.println("m2 -> "+ Thread.currentThread().getName());
    }
}

/*
class MyThread1 implements Runnable {

    ObjectLevelLock levelLock = new ObjectLevelLock();

    MyThread1( ObjectLevelLock levelLock) {
        this.levelLock = levelLock;
    }

    @Override
    public void run() {

    }
}

class MyThread2 implements Runnable {

    ObjectLevelLock levelLock = new ObjectLevelLock();

    MyThread2( ObjectLevelLock levelLock) {
        this.levelLock = levelLock;
    }

    @Override
    public void run() {

    }
}
*/




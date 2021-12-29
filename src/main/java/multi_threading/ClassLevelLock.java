package multi_threading;

public class ClassLevelLock {
    public static void main(String[] args) {

        ClassLevelLock l1 = null;

        Thread t1 = new Thread(() -> {
            m1();
            m2();
        });

        Thread t2 = new Thread(() -> {
            m1();
            m2();
        });



        t1.start();
        t2.start();
    }

    public static synchronized void m1() {
        System.out.println("m1 -> "+ Thread.currentThread().getName());
    }


    public static synchronized void m2() {
        System.out.println("m2 -> "+ Thread.currentThread().getName());
    }
}

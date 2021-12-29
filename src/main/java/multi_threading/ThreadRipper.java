package multi_threading;

public class ThreadRipper implements Runnable {
    public static void main(String[] args) {
        new Thread(new ThreadRipper("Wallace")).start();
        new Thread(new ThreadRipper("Gromit")).start();
    }

    public String name;
    public ThreadRipper(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        message(1);
        message(2);
    }

    private synchronized void message(int n) {
        System.out.println(name + "-" + n + " ");
    }
}

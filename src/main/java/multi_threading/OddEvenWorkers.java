package multi_threading;

public class OddEvenWorkers {
    public static void main(String[] args) {

    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        
    }
}

class Odd {

    int number;

    Odd(int number) {
        this.number = number;
    }

    @Override
    public synchronized String toString() {
        return "Odd{" +
                "number=" + number++ +
                '}';
    }
}


class Even {

    int number;

    Even(int number) {
        this.number = number;
    }

    @Override
    public synchronized String toString() {
        return "Even{" +
                "number=" + number++ +
                '}';
    }
}
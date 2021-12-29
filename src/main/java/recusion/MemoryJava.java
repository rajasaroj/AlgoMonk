package recusion;

public class MemoryJava {
    public static void main(String[] args) {
        decbyone(2);
    }

    public static void decbyone(int num) {
        if (num >= 0) {
            decbyone(num-1);
        }
        System.out.println(num);
    }
}

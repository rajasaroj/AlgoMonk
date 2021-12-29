package basics;

public class IniTest {

    public static int sum=0;



    static {
        initialize();
    }

    public static boolean initialized = false;

    public static int getNum() {
        initialize();
        return sum;
    }

    public static void disp() {
        System.out.println();
    }

    public static void initialize() {
        if (!initialized) {
            for (int i = 0; i < 100; i++) {
                sum+=i;
            }
            initialized=true;
        }
    }

    public static void main(String[] args) {
        System.out.println("");
        System.out.println();
        System.out.println(IniTest.getNum());
        IniTest.disp();
    }
}

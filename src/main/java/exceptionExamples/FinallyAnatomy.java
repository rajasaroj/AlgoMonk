package exceptionExamples;

public class FinallyAnatomy {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        try {
            System.out.println("in try");
            throw new Exception();

        } catch (Exception ex) {
            System.out.println("in catch");
            throw new Exception();
        } finally {
            System.out.println("something is printed");
            return 1;
        }
    }
}

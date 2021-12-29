package basics;

class A {}
class B extends A {}
class C extends B {}

public class WhoYourInstance {
    public static void main(String[] args) {
        B b = new B();

        System.out.println(b instanceof B);
        System.out.println(b instanceof A);
        System.out.println(b instanceof C);  // False
    }
}

package basics;

public class Base {
    final public void show() {
        System.out.println("Base::show() called");
    }
}

class Derived extends Base {
    // Error Compile time
//    public void show() {
//
//    }
}

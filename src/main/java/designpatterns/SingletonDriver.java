package designpatterns;

public class SingletonDriver {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getINSTANCE();
        Singleton s2 = Singleton.getINSTANCE();

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

package Prototype;

public class Main {
    public static void main(String[] args) {
        Prototype p = new ConcretePrototype1(1);
        Prototype c = p.clone();

        System.out.println(p.toString());
        System.out.println(c.toString());

        p = new ConcretePrototype2(2);
        c = p.clone();

        System.out.println(p.toString());
        System.out.println(c.toString());
    }
}

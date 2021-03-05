package Strategy;

public class Main {
    public static void main(String[] args) {
        Context c = new Context(new ConcreteStrategy1());
        c.contextInterface();

        c = new Context(new ConcreteStrategy2());
        c.contextInterface();

        c = new Context(new ConcreteStrategy3());
        c.contextInterface();
    }
}

package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        Client cl = new Client(new Factory1());
        cl.run();

        cl = new Client(new Factory2());
        cl.run();
    }
}

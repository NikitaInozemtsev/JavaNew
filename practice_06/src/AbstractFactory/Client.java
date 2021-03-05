package AbstractFactory;

public class Client {
    AbstractProductA a;
    AbstractProductB b;

    public Client(AbstractFactory f) {
        a = f.createProductA();
        b = f.createProductB();
    }

    public void run() {
        b.interact(a);
    }
}

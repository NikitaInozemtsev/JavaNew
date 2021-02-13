package Builder;


public class Main {
    public static void main(String[] args) {
        Builder b = new ConcreteBuilder();
        Director d = new Director(b);
        d.construct();
        Product p = b.getResult();
        p.show();
    }
}

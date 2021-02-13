package AbstractFactory;

public class ProductB1 extends AbstractProductB{
    @Override
    public void interact(AbstractProductA a) {
        System.out.println(this.toString() + " interacts with " + a.toString());
    }
}

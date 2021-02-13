package Prototype;

public class ConcretePrototype1 extends Prototype{
    public ConcretePrototype1(int id) {
        super(id);
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype1(id);
    }
}

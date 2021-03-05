package Prototype;

public class ConcretePrototype2 extends Prototype{
    public ConcretePrototype2(int id) {
        super(id);
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype2(id);
    }
}

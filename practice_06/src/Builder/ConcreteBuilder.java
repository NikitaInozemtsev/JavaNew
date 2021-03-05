package Builder;

public class ConcreteBuilder extends Builder{
    Product p = new Product();
    @Override
    public void buildPartA() {
        p.add("Part A");
    }

    @Override
    public void buildPartB() {
        p.add("Part B");
    }

    @Override
    public void buildPartC() {
        p.add("Part C");
    }

    @Override
    public Product getResult() {
        return p;
    }
}

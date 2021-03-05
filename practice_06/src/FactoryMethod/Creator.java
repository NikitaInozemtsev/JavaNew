package FactoryMethod;

public abstract class Creator {
    Product product;
    public abstract Product FactoryMethod();

    public void anOperation() {
        product = FactoryMethod();
    }
}

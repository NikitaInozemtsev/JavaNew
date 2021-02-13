package FactoryMethod;

public class Main {
    public static void main(String[] args) {
        Creator a = new ConcreteCreator();
        Product b = a.FactoryMethod();
        a.anOperation();
    }
}

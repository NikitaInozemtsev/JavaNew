package Adapter;

public class Adapter extends Target{

    Adaptee a = new Adaptee();
    @Override
    public void request() {
        a.specificRequest();
    }
}

package Proxy;

public class RealSubject extends Subject{
    @Override
    public void request() {
        System.out.println("TestMessage");
    }
}

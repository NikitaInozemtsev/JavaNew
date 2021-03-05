package Proxy;

public class Client {
    public static void main(String[] argv){
        Subject subject = new Proxy();
        subject.request();
    }
}

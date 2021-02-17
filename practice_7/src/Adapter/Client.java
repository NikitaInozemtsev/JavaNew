package Adapter;

public class Client {
    public static void main(String[] argv){
        Target target = new Adapter();
        target.request();
    }
}

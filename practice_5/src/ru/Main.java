package ru;

public class Main {
    public static void main(String[] argv){
        Singleton1 a = new Singleton1();
        a.getInstance();
        Singleton2 b = Singleton2.getInstance();
        Singleton3 c = Singleton3.getInstance();
    }
}

package ru;

public enum Singleton2 {
    INSTANCE;
    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}

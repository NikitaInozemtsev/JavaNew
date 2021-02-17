package ru;

public class Item implements AllFunc{
    public String name;
    public String creationDate;
    public int price;

    public Item(String name, String creationDate, int price) {
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", price=" + price +
                '}';
    }
}

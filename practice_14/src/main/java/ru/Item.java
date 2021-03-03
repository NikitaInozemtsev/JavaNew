package ru;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item implements AllFunc{
    @JsonProperty("name")
    public String name;
    @JsonProperty("creationDate")
    public String creationDate;
    @JsonProperty("price")
    public int price;

    public Item() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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

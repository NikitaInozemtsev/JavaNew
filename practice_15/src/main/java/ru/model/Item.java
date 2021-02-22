package ru.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @Column(name = "name")
    public String name;
    @Column(name = "creationDate")
    public String creationDate;
    @Column(name = "price")
    public int price;

    public Item() { }

    public Item(String name, String creationDate, int price) {
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public int getPrice() {
        return price;
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

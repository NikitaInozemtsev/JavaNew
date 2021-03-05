package Prototype;

public abstract class Prototype {
    int id;

    public Prototype(int id) {
        this.id = id;
    }

    public abstract Prototype clone();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

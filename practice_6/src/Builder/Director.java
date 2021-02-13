package Builder;

public class Director {
    Builder b;

    public Director(Builder b) {
        this.b = b;
    }

    public void construct() {
        b.buildPartA();
        b.buildPartB();
        b.buildPartC();
    }
}

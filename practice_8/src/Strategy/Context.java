package Strategy;

public class Context {
    Strategy strategy;

    public Context(Strategy s) {
        this.strategy = s;
    }

    public void contextInterface() {
        strategy.algorithmInterface();
    }
}

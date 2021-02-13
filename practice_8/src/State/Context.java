package State;

public class Context {
    State state;

    public Context(State state) {
        this.state = state;
    }

    public void request() {
        this.state.handle(this);
        System.out.println("New state is " + state.toString());
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}

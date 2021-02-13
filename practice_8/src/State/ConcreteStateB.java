package State;

public class ConcreteStateB extends State{
    @Override
    public void handle(Context c) {
        c.state = new ConcreteStateA();
    }
}

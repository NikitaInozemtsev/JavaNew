package State;

public class ConcreteStateA extends State{
    @Override
    public void handle(Context c) {
        c.state = new ConcreteStateB();
    }
}

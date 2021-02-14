package df.guiPart;

import org.springframework.stereotype.Component;

@Component
public class Merkel implements Politician{
    @Override
    public void doPolitic() {
        System.out.println("Olw woman");
    }
}

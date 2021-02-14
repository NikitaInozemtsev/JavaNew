package df.guiPart;

import org.springframework.stereotype.Component;

@Component
public class Biden implements Politician{

    @Override
    public void doPolitic() {
        System.out.println("Old man");
    }
}

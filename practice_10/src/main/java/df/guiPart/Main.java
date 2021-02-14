package df.guiPart;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Politician pol1 = context.getBean(Merkel.class);
        Politician pol2 = context.getBean(Trump.class);
        Politician pol3 = context.getBean(Biden.class);
        pol1.doPolitic();
        pol2.doPolitic();
        pol3.doPolitic();


    }
}

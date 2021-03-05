package df.guiPart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication


public class Practice12Application {

	public static void main(String[] args) {

//		ConfigurableApplicationContext ctx = new
//				SpringApplicationBuilder(Conf.class).web(WebApplicationType.NONE).run();

//		ApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
//		FileRW fileRW = context.getBean(FileRW.class);


		System.out.println("Spring Boot application started");

		//SpringApplication.exit(ctx, () -> 0);

		SpringApplication.run(Practice12Application.class, args);

	}

}

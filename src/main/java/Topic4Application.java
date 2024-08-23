import com.globant.training.java.topic4.controller.injection.*;
import com.globant.training.java.topic4.service.injection.config.BingindConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.globant.training.java.topic4"})
@SpringBootApplication
public class Topic4Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Topic4Application.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		System.out.println("--------Profile");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.hello());

		System.out.println("--------Primary");
		HelloController helloController = (HelloController) ctx.getBean("helloController");
		String hello = helloController.hello();
		System.out.println(hello);

		System.out.println("--------Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getHello());

		System.out.println("--------Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getHello());

		System.out.println("--------Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getHello());

		System.out.println("--------Config Props");

		// SpringApplication.run(Topic4Application.class, args);
		BingindConfig bingindConfig = ctx.getBean(BingindConfig.class);
		System.out.println(bingindConfig.getBinding());
	}

}

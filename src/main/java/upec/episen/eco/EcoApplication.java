package upec.episen.eco;

import com.sun.glass.ui.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import upec.episen.eco.service.consumption.ComsumptionService;

@SpringBootApplication
public class EcoApplication {

	public static void main(String[] args) {

		SpringApplication.run(EcoApplication.class, args);
		//ApplicationContext context = SpringApplication.run(Application.class, args);
		//ComsumptionService consumptionService = context.getBean(ComsumptionService.class);
		//System.out.println(consumptionService.getOrderedItemsById(1L));
	}

}

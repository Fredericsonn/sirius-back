package upec.episen.eco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import upec.episen.eco.service.consumption.ComsumptionService;

@SpringBootApplication
public class EcoApplication {

	public static void main(String[] args) {

		SpringApplication.run(EcoApplication.class, args);
		//ComsumptionService c = new ComsumptionService();
		//System.out.println(c.getOrderedItemsById(1L));
	}

}

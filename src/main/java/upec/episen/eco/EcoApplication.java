package upec.episen.eco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import upec.episen.eco.models.machine.Component;
import upec.episen.eco.models.machine.Device;
import upec.episen.eco.models.machine.Matter;
import upec.episen.eco.models.machine.enums.UsageCategory;
import upec.episen.eco.service.machine.MachineService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EcoApplication {



	public static void main(String[] args) {
		SpringApplication.run(EcoApplication.class, args);
	}


}
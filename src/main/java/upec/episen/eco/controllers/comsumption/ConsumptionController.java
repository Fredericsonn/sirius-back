package upec.episen.eco.controllers.comsumption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upec.episen.eco.models.consumption.Consumption;
import upec.episen.eco.service.consumption.ConsumptionService;

@RestController
@RequestMapping("/consumptions")
public class ConsumptionController {

    @Autowired
    ConsumptionService consumptionService;

    @GetMapping("/allConsommations")
    public List<Consumption> consumption() {
        return  consumptionService.getAll();
    }
}

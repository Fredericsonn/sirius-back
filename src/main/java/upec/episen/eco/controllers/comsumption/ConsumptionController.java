package upec.episen.eco.controllers.comsumption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upec.episen.eco.models.consumption.Comsumption;
import upec.episen.eco.service.consumption.ComsumptionService;

@RestController
@RequestMapping("/consumption/consumption")
public class ConsumptionController {

    @Autowired
    ComsumptionService consumptionService;

    @GetMapping("/allConsommations")
    public List<Comsumption> consumption() {
        return  consumptionService.getAll();
    }

}

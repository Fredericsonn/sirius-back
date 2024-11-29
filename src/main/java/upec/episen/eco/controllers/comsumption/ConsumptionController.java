package upec.episen.eco.controllers.comsumption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upec.episen.eco.models.Comsumption.ComsumptionModel;
import upec.episen.eco.service.comsumption.ComsumptionService;

import java.util.List;

@RestController
@RequestMapping("/consumption/consumption")
public class ConsumptionController {

    @Autowired
    ComsumptionService consumptionService;

    @GetMapping("/allConsommations")
    public List<ComsumptionModel> consumption() {
        return  consumptionService.getAll();
    }

}

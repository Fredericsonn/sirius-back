package upec.episen.eco.controllers.comsumption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upec.episen.eco.models.consumption.ComsumptionItem;
import upec.episen.eco.service.consumption.ComsumptionService;

@RestController
@RequestMapping("/comsumptions")
public class ConsumptionController {

    @Autowired
    private ComsumptionService conServ;

    @GetMapping("/{id}/items")
    public List<ComsumptionItem> getOrderedItems(@PathVariable Long id){
        return conServ.getOrderedItemsById(id);
    }


}

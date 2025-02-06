package upec.episen.eco.controllers.consumption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upec.episen.eco.models.consumption.ConsumptionItem;
import upec.episen.eco.service.consumption.ConsumptionService;

@RestController
@RequestMapping("/comsumptions")
public class ConsumptionController {

    @Autowired
    private ConsumptionService conServ;

    @GetMapping("/{id}/items")
    public List<ConsumptionItem> getOrderedItems(@PathVariable Long id){
        return conServ.getOrderedItemsById(id);
    }


}

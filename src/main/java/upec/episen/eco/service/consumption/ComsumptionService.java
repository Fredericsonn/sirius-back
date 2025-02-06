package upec.episen.eco.service.consumption;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.models.consumption.Consumption;
import upec.episen.eco.models.consumption.ConsumptionItem;
import upec.episen.eco.repositories.comsumption.IComsumption;

@Service
public class ComsumptionService {

    @Autowired
    private IComsumption comsumptionRepository;

    public Consumption createConsumption(String name, Set<ConsumptionItem> items) {
        Consumption consumption = new Consumption();
        consumption.setName(name);
        consumption.setComsumptionItems(items);
        return comsumptionRepository.save(consumption);
    }

    public Consumption getConsumptionById(Long id) {
        return comsumptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumption not found"));
    }

    public List<ConsumptionItem> getOrderedItemsById(Long id){
        return comsumptionRepository.getOrderedItemsById(id);
    }


}
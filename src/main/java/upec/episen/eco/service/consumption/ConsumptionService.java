package upec.episen.eco.service.consumption;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.models.consumption.Consumption;
import upec.episen.eco.models.consumption.ConsumptionItem;
import upec.episen.eco.repositories.consumption.IConsumption;

@Service
public class ConsumptionService {

    @Autowired
    private IConsumption consumptionRepository;

    public Consumption createConsumption(String name, Set<ConsumptionItem> items) {
        Consumption consumption = new Consumption();
        consumption.setName(name);
        consumption.setConsumptionItems(items);
        return consumptionRepository.save(consumption);
    }

    public Consumption getConsumptionById(Long id) {
        return consumptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumption not found"));
    }

    public List<ConsumptionItem> getOrderedItemsById(Long id){
        return consumptionRepository.getOrderedItemsById(id);
    }


}
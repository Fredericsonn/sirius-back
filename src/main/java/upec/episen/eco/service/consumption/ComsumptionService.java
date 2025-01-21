package upec.episen.eco.service.consumption;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.models.consumption.Comsumption;
import upec.episen.eco.models.consumption.ComsumptionItem;
import upec.episen.eco.repositories.comsumption.IComsumption;

@Service
public class ComsumptionService {

    @Autowired
    private IComsumption comsumptionRepository;

    public Comsumption createConsumption(String name, Set<ComsumptionItem> items) {
        Comsumption consumption = new Comsumption();
        consumption.setName(name);
        consumption.setComsumptionItems(items);
        return comsumptionRepository.save(consumption);
    }

    public Comsumption getConsumptionById(Long id) {
        return comsumptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumption not found"));
    }

    public List<ComsumptionItem> getOrderedItemsById(Long id){
        return comsumptionRepository.getOrderedItemsById(id);
    }


}
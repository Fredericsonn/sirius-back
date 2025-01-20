package upec.episen.eco.service.consumption;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upec.episen.eco.models.consumption.ComsumptionItem;
import upec.episen.eco.repositories.comsumption.IComsumptionItem;

import upec.episen.eco.models.consumption.Comsumption;
import upec.episen.eco.models.machine.enums.UsageCategory;
import upec.episen.eco.repositories.comsumption.IComsumption;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComsumptionService {

    @Autowired
    private IComsumptionItem comsumptionItemRepository;

    public List<Comsumption> getAll(){
        return consumptionrepo.findAll();

    public List<ComsumptionItem> getSortedComsumptionItems() {
        // Récupérer tous les ComsumptionItem depuis la base de données
        List<ComsumptionItem> items = comsumptionItemRepository.findAll();

        // Trier les items en fonction du rapport (carbonFootprint / quantity)
        return items.stream()
                .sorted((item1, item2) -> Double.compare(
                        (item2.getCarbonFootprint() / item2.getQuatity()),
                        (item1.getCarbonFootprint() / item1.getQuatity())))
                .collect(Collectors.toList());
    }


    public List<ComsumptionItem> getSortedComsumptionItemsByConsumption(long consumptionId) {
        // Récupérer tous les ComsumptionItems associés à une consommation spécifique
        List<ComsumptionItem> items = comsumptionItemRepository.findAll().stream()
                .filter(item -> item.getConsumption().getId() == consumptionId)
                .collect(Collectors.toList());

        // Trier les items par le rapport (carbonFootprint / quantity)
        return items.stream()
                .sorted((item1, item2) -> Double.compare(
                        (item2.getCarbonFootprint() / item2.getQuatity()),
                        (item1.getCarbonFootprint() / item1.getQuatity())))
                .collect(Collectors.toList());
    }
}

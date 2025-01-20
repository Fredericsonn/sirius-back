package upec.episen.eco.controllers.comsumption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upec.episen.eco.models.consumption.ComsumptionItem;
import upec.episen.eco.service.consumption.ComsumptionService;

import java.util.List;

@RestController
@RequestMapping("/api/consumption-items")
public class ComsumptionItemController {

    @Autowired
    private ComsumptionService comsumptionService;

    /**
     * Endpoint pour obtenir tous les ComsumptionItems triés par rapport (carbonFootprint / quantity)
     * @return Liste des ComsumptionItem triée
     */
    @GetMapping("/sorted")
    public List<ComsumptionItem> getSortedComsumptionItems() {
        return comsumptionService.getSortedComsumptionItems();
    }

    /**
     * Endpoint pour obtenir les ComsumptionItems triés pour une consommation spécifique
     * @param consumptionId Identifiant de la consommation
     * @return Liste des ComsumptionItem triée pour la consommation spécifiée
     */
    @GetMapping("/sorted/{consumptionId}")
    public List<ComsumptionItem> getSortedComsumptionItemsByConsumption(@PathVariable long consumptionId) {
        return comsumptionService.getSortedComsumptionItemsByConsumption(consumptionId);
    }
}

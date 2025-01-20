package upec.episen.eco.repositories.comsumption;

import org.springframework.data.jpa.repository.JpaRepository;
import upec.episen.eco.models.consumption.ComsumptionItem;

public interface IComsumptionItem extends JpaRepository<ComsumptionItem, Long> {
    // Nous pouvons ajouter des méthodes personnalisées si nécessaire.
}


package upec.episen.eco.repositories.consumption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upec.episen.eco.models.consumption.ConsumptionItem;

@Repository
public interface IConsumptionItem extends JpaRepository<ConsumptionItem, Long> {
    // Nous pouvons ajouter des méthodes personnalisées si nécessaire.
}


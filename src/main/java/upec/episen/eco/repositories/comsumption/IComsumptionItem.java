package upec.episen.eco.repositories.comsumption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upec.episen.eco.models.consumption.ComsumptionItem;

@Repository
public interface IComsumptionItem extends JpaRepository<ComsumptionItem, Long> {
    // Nous pouvons ajouter des méthodes personnalisées si nécessaire.
}


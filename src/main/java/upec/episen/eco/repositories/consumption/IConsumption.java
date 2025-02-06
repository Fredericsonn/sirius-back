package upec.episen.eco.repositories.consumption;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import upec.episen.eco.models.consumption.Consumption;
import upec.episen.eco.models.consumption.ConsumptionItem;

@Repository
public interface IConsumption extends JpaRepository<Consumption,Long> {
    @Query("SELECT ci FROM consumption_item ci WHERE ci.comsumption.id = :comsumptionId " + "ORDER BY ci.carbonFootprint / ci.quatity DESC")
    List<ConsumptionItem> getOrderedItemsById(Long comsumptionId);}

package upec.episen.eco.repositories.comsumption;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import upec.episen.eco.models.consumption.Comsumption;
import upec.episen.eco.models.consumption.ComsumptionItem;

@Repository
public interface IComsumption extends JpaRepository<Comsumption,Long> {
    @Query("SELECT ci FROM consumption_item ci WHERE ci.comsumption.id = :comsumptionId " + "ORDER BY ci.carbonFootprint / ci.quatity DESC")
    List<ComsumptionItem> getOrderedItemsById(Long comsumptionId);}

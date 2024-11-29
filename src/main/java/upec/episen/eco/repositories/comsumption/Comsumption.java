package upec.episen.eco.repositories.comsumption;

import org.springframework.data.jpa.repository.JpaRepository;
import upec.episen.eco.models.Comsumption.ComsumptionModel;

public interface Comsumption extends JpaRepository<ComsumptionModel,Long> {
}

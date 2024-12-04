package upec.episen.eco.repositories.comsumption;

import org.springframework.data.jpa.repository.JpaRepository;

import upec.episen.eco.models.consumption.ComsumptionModel;

public interface Comsumption extends JpaRepository<ComsumptionModel,Long> {
}

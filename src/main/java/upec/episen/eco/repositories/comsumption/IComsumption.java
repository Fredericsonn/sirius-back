package upec.episen.eco.repositories.comsumption;

import org.springframework.data.jpa.repository.JpaRepository;

import upec.episen.eco.models.consumption.Comsumption;

public interface IComsumption extends JpaRepository<Comsumption,Long> {
}

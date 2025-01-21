package upec.episen.eco.repositories.comsumption;

import org.springframework.data.jpa.repository.JpaRepository;

import upec.episen.eco.models.consumption.Consumption;

public interface IConsumption extends JpaRepository<Consumption,Long> {
    
}

package upec.episen.eco.repositories.norms;

import org.springframework.data.jpa.repository.JpaRepository;

import upec.episen.eco.models.consumption.EnergyType;
import upec.episen.eco.models.norms.EmissionFactor;

public interface IEmissionFactor extends JpaRepository<EmissionFactor, Long> {

    EmissionFactor findByEnergyType(EnergyType type);
}

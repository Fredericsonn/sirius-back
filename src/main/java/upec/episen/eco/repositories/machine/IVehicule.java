package upec.episen.eco.repositories.machine;

import org.springframework.data.jpa.repository.JpaRepository;
import upec.episen.eco.models.machine.Vehicle;
import upec.episen.eco.models.machine.enums.UsageCategory;

import java.util.List;

public interface IVehicule extends JpaRepository<Vehicle,Integer> {
    List<Vehicle> findByUsage(UsageCategory usage);
}

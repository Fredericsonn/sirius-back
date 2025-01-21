package upec.episen.eco.repositories.machine;

import org.springframework.data.jpa.repository.JpaRepository;
import upec.episen.eco.models.machine.Device;
import upec.episen.eco.models.machine.enums.UsageCategory;

import java.util.List;

public interface IDevice extends JpaRepository<Device, Integer> {
    List<Device> findByUsage(UsageCategory usage);
}

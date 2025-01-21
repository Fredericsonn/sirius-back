package upec.episen.eco.repositories.machine;

import org.springframework.data.jpa.repository.JpaRepository;
import upec.episen.eco.models.machine.Machine;

public interface IMachine extends JpaRepository<Machine, Long> {
}

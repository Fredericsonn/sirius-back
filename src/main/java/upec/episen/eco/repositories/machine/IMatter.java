package upec.episen.eco.repositories.machine;

import org.springframework.data.jpa.repository.JpaRepository;
import upec.episen.eco.models.machine.Matter;

public interface IMatter extends JpaRepository<Matter,Integer> {
}

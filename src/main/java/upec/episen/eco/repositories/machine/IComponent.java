package upec.episen.eco.repositories.machine;

import org.springframework.data.jpa.repository.JpaRepository;
import upec.episen.eco.models.machine.Component;

public interface IComponent extends JpaRepository<Component,Long> {
}

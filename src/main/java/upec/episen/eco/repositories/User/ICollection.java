package upec.episen.eco.repositories.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import upec.episen.eco.models.User.Collection;
import upec.episen.eco.models.User.User;

public interface ICollection extends JpaRepository<Collection, Long> {

    List<Collection> findAllByUser(User user);

}

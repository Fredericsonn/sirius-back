package upec.episen.eco.repositories.User;

import org.springframework.data.jpa.repository.JpaRepository;

import upec.episen.eco.models.User.User;

public interface IUser extends JpaRepository<User, Long> {

}

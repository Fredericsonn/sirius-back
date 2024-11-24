package upec.episen.eco.service.User;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.exceptions.UserNotFoundException;
import upec.episen.eco.models.User.User;
import upec.episen.eco.repositories.User.IUser;
import upec.episen.eco.service.ServiceHelper;

@Service
public class UserService {

    @Autowired
    private IUser iuser;

    // find a user by its id
    public User getUserById(Long id) throws UserNotFoundException {

        Optional<User> user = iuser.findById(id);

        if (user.isPresent()) return user.get();

        throw new UserNotFoundException(id);
    }

    // delete a user
    public void deleteUser(Long id) throws UserNotFoundException {

        Optional<User> user = iuser.findById(id);

        if (user.isPresent()) iuser.delete(user.get());
        
        throw new UserNotFoundException(id);
    }

    // save a new user
    public User saveUser(User user) {
        return iuser.save(user);
    }

    // update an existing user
    public String updateUser(Long id, Map<String, Object> updates) {

        try {

            User user = getUserById(id);

            ServiceHelper.genericUpdate(user, updates);

            saveUser(user);

            return "User successfully updated";

        } catch (UserNotFoundException e) {

            return e.getMessage();
        }

    }
}

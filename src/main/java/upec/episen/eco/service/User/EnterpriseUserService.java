package upec.episen.eco.service.User;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upec.episen.eco.exceptions.UserNotFoundException;
import upec.episen.eco.models.User.Enterprise;
import upec.episen.eco.models.User.Person;
import upec.episen.eco.repositories.User.IEnterpriseUser;
import upec.episen.eco.service.ServiceHelper;

@Service
public class EnterpriseUserService {

    @Autowired
    private IEnterpriseUser iuser;

    // find a user by its id
    public Enterprise getUserById(Long id) throws UserNotFoundException {

        Optional<Enterprise> user = iuser.findById(id);

        if (user.isPresent())
            return user.get();

        throw new UserNotFoundException(id);
    }

    // get all users
    public List<Enterprise> getAllUsers() {
        return iuser.findAll();
    }

    // delete a user
    public void deleteUser(Long id) throws UserNotFoundException {

        Optional<Enterprise> user = iuser.findById(id);

        if (user.isPresent())
            iuser.delete(user.get());

        throw new UserNotFoundException(id);
    }

    // save a new user
    public Enterprise saveUser(Enterprise user) {
        return iuser.save(user);
    }

    // update an existing user
    public String updateUser(Long id, Map<String, Object> updates) {

        try {

            Enterprise user = getUserById(id);

            ServiceHelper.genericUpdate(user, updates);

            saveUser(user);

            return "User successfully updated";

        } catch (UserNotFoundException e) {

            return e.getMessage();
        }

    }

}

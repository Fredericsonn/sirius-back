package upec.episen.eco.exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(Long id) {
        System.out.println("The id :" + id + " doesn't correspond to any existing user.");
    }
}

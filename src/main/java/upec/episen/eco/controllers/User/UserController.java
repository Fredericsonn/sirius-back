package upec.episen.eco.controllers.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import upec.episen.eco.exceptions.UserNotFoundException;
import upec.episen.eco.models.User.Enterprise;
import upec.episen.eco.models.User.Person;
import upec.episen.eco.models.User.User;
import upec.episen.eco.service.User.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userservice;

    @Autowired
    private DelegatingPasswordEncoder encoder;

    @GetMapping
    public List<User> getAllUsers(@RequestParam(name = "type", required = false) String type) {

        if (type != null) {
            return userservice.getAllUsersByType(type);
        }

        return userservice.getAllUsers();
    }

    @GetMapping("/{username}")
    public User getUserById(@PathVariable String username) {
        try {
            return userservice.getUserByUsername(username);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/person/post")
    public ResponseEntity<?> postUser(@RequestBody Person user) {
        Map<String, Object> body = new HashMap<String, Object>();
        HttpStatus status;
        String msg;

        try {
            user.setPassword(encoder.encode(user.getPassword()));
            userservice.saveUser(user);
            msg = "User created successfully.";
            status = HttpStatus.CREATED;
        } catch (Exception e) {
            msg = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        body.put("msg", msg);

        return ResponseEntity.status(status).body(body);
    }

    @PostMapping("/enterprise/post")
    public ResponseEntity<?> postUser(@RequestBody Enterprise user) {
        Map<String, Object> body = new HashMap<String, Object>();
        HttpStatus status;
        String msg;

        try {
            user.setPassword(encoder.encode(user.getPassword()));
            userservice.saveUser(user);
            msg = "User created successfully.";
            status = HttpStatus.CREATED;
        } catch (Exception e) {
            msg = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        body.put("msg", msg);

        return ResponseEntity.status(status).body(body);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody Map<String, Object> updates) {
        Map<String, Object> body = new HashMap<String, Object>();
        HttpStatus status;
        String msg;

        try {
            userservice.updateUser(id, updates);
            msg = "User updated successfully";
            status = HttpStatus.OK;
        } catch (Exception e) {
            msg = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        body.put("msg", msg);

        return ResponseEntity.status(status).body(body);
    }

}

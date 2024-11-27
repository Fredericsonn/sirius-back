package upec.episen.eco.controllers.User;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upec.episen.eco.models.User.Person;
import upec.episen.eco.service.User.PersonUserService;

@RestController
@RequestMapping("/users/person")
public class PersonController {

    @Autowired
    private PersonUserService userservice;

    @Autowired
    private BCryptPasswordEncoder encoder;  

    @GetMapping() 
    public List<Person> getAllUsers() {
        return userservice.getAllUsers();
    }
    
    @PostMapping("/post")
    public ResponseEntity<?> postUser(@RequestBody Person user) {
        Map<String, Object> body = new HashMap<String, Object>();
        String msg;
        int status;
        try {
            user.setPassword(encoder.encode(user.getPassword()));
            userservice.saveUser(user);
            msg = "User created successfully";
            status = 201;

        } catch (Exception e) {
            msg = e.getMessage();
            status = 400;
        }
        body.put("msg", msg);
        return ResponseEntity.status(status).body(body);
    }
}

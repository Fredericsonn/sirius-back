package upec.episen.eco.controllers.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upec.episen.eco.models.User.Enterprise;
import upec.episen.eco.service.User.EnterpriseUserService;

@RestController
@RequestMapping("/users/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseUserService userservice;

    // @Autowired
    // private BCryptPasswordEncoder encoder;   // will be used later for authentication

    @GetMapping()
    public List<Enterprise> getAllUsers() {
        return userservice.getAllUsers();
    }

    @PostMapping("/post")
    public ResponseEntity<?> postUser(@RequestBody Enterprise user) {
        Map<String, Object> body = new HashMap<String, Object>();
        String msg;
        int status;
        try {
            // user.setPassword(encoder.encode(user.getPassword()));
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

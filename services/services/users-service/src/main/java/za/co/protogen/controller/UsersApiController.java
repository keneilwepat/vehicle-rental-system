package za.co.protogen.controller;


import org.springframework.web.bind.annotation.*;
import za.co.protogen.model.User;
import za.co.protogen.utility.Constants;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersApiController {

    @GetMapping
    public List<User> getAllUsers() {
        return Constants.users;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        Constants.users.add(user);
    }
}

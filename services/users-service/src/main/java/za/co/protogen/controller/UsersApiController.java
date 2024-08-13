package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.adapter.Mappers;
import za.co.protogen.persistence.User;
import za.co.protogen.util.Constants;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersApiController {

    @Autowired
    private Mappers mappers;

    @GetMapping
    public Collection<User> getUsers() {
        return mappers.mapToUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return (User) Constants.users.get(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        Long id = Long.valueOf(UUID.randomUUID().toString());
        user.setId(id);
        Constants.users.put(String.valueOf(id), user);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        Constants.users.put(String.valueOf(id), user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        Constants.users.remove(id);
    }
}

package za.co.protogen.adapter;

import org.springframework.stereotype.Component;
import za.co.protogen.persistence.User;
import za.co.protogen.util.Constants;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mappers {

    public User mapToUser(Long id, String name, String email) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        return user;
    }

    public List<User> mapToUsers() {
        List<User> users = new ArrayList<>();
        for (Object value : Constants.users.values()) {
            users.add((User) value);
        }
        return users;
    }
}

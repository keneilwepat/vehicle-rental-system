/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen.core.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;

/**
 *
 * @author makox
 */
public class UserServiceImpl implements UserService {
    
   

    @Override
    public void addUser(User user) {
        Constant.users.add(user);
    }

    @Override
    public void removeUser(Long userId) {
        for (int i = 0; i < Constant.users.size(); i++) {
            if (Constant.users.get(i).getId().equals(userId)) {
                Constant.users.remove(i);
                break;
            }
        }
    }

    @Override
    public User getUserById(Long userId) {
        for (User user : Constant.users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(Constant.users);
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; i < Constant.users.size(); i++) {
            if (Constant.users.get(i).getId().equals(user.getId())) {
                Constant.users.set(i, user);
                return;
            }
        }
    }

    @Override
    public List<User> searchUsers(String firstName, String lastName, LocalDate dateOfBirth) {
        List<User> result = new ArrayList<>();
        for (User user : Constant.users) {
            boolean matches = true;
            if (firstName != null && !user.getFirstName().equalsIgnoreCase(firstName)) {
                matches = false;
            }
            if (lastName != null && !user.getLastName().equalsIgnoreCase(lastName)) {
                matches = false;
            }
            if (dateOfBirth != null && !user.getDateOfBirth().equals(dateOfBirth)) {
                matches = false;
            }
            if (matches) {
                result.add(user);
            }
        }
        return result;
    }
}

    


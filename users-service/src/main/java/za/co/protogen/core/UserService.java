/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.co.protogen.core;

import java.time.LocalDate;
import java.util.List;
import za.co.protogen.domain.User;

/**
 *
 * @author makox
 */
public interface UserService {
    

    void addUser(User user);
    void removeUser(Long userId);
    User getUserById(Long userId);
    List<User> getAllUsers();
    void updateUser(User user);
    List<User> searchUsers(String firstName, String lastName, LocalDate dateOfBirth);
}
    
    
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.protogen;

import java.time.LocalDate;
import java.util.List;
import za.co.protogen.core.UserService;
import za.co.protogen.core.impl.UserServiceImpl;
import za.co.protogen.domain.User;

/**
 *
 * @author makox
 */
public class Application {
    
 
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // Add a new user
        User newUser = new User();
        newUser.setId(3L);
        newUser.setFirstName("Alice");
        newUser.setLastName("Johnson");
        newUser.setDateOfBirth(LocalDate.of(1992, 7, 20));
        newUser.setRsaId("1122334455667");
        userService.addUser(newUser);

        // Get all users
        System.out.println("All Users:");
        List<User> allUsers = userService.getAllUsers();
        allUsers.forEach(System.out::println);

        // Get user by ID
        User retrievedUser = userService.getUserById(1L);
        System.out.println("Retrieved User: " + retrievedUser);

        // Update user
        retrievedUser.setLastName("Doe-Smith");
        userService.updateUser(retrievedUser);
        System.out.println("Updated User: " + userService.getUserById(1L));

        // Search users
        List<User> searchResults = userService.searchUsers("Alice", null, null);
        System.out.println("Search Results:");
        searchResults.forEach(System.out::println);

        // Remove user
        userService.removeUser(2L);
        System.out.println("User removed. Remaining users:");
        userService.getAllUsers().forEach(System.out::println);
    }

  
    
    
    
}

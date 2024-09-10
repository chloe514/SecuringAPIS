package org.example.securingapis.services;

import org.example.securingapis.models.User;
import org.example.securingapis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Inject password encoder

    /**
     * Registers a new user by encoding the password and saving the user details.
     *
     * @param user the user object containing user details to be registered
     * @return the saved user object
     */
    public User registerUser(User user) {
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of("USER"));
        return userRepository.save(user);  // Save user with encoded password
    }

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user to find
     * @return the user object if found, otherwise null
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Add other methods as needed, such as updating user details, deleting users, etc.

}




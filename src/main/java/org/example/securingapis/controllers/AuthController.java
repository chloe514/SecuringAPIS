package org.example.securingapis.controllers;

import org.example.securingapis.models.LoginRequest;
import org.example.securingapis.models.UserDTO;
import org.example.securingapis.security.JwtTokenUtil;
import org.example.securingapis.services.JwtUserDetailsService;
import org.example.securingapis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    // Endpoint for user registration
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        // Registration logic
        userService.registerUser(userDTO.toUser());
        return ResponseEntity.ok("User registered successfully!");
    }

    // Endpoint for user login
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) throws AuthenticationException {
        try {
            // Authenticate the user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials!");
        }

        // Generate JWT token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return "JWT Token: " + token;
    }

    // Optional: Endpoint to manually generate a token
    @GetMapping("/token")
    public String generateToken(@RequestParam String username) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return "Generated Token: " + token;
    }
}



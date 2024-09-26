package com.bookself.bookself_api.controllers;

import com.bookself.bookself_api.dtos.UserDTO;
import com.bookself.bookself_api.mappers.UserMapper;
import com.bookself.bookself_api.models.User;
import com.bookself.bookself_api.models.UserRole;
import com.bookself.bookself_api.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // Registration endpoint
    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.USER);  // Default to USER role
        return UserMapper.toDTO(userService.saveUser(user));
    }

    // Login endpoint (Session-based authentication)
    @PostMapping("/login")
    public String loginUser(@RequestBody UserDTO userDTO, HttpSession session) {
        Optional<User> userOpt = userService.findUserByEmail(userDTO.getEmail());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
                session.setAttribute("user", user);  // Create session
                return "Login successful!";
            }
        }
        return "Invalid email or password!";
    }

    // Logout endpoint
    @PostMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();  // Invalidate session
        return "Logged out successfully!";
    }

    // View user profile
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        return user.map(UserMapper::toDTO).orElse(null);
    }

    // Update user profile
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}")
    public UserDTO updateUserProfile(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        Optional<User> userOpt = userService.findUserById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setName(userDTO.getName());
            user.setBio(userDTO.getBio());
            user.setProfilePhotoUrl(userDTO.getProfilePhotoUrl());
            return UserMapper.toDTO(userService.saveUser(user));
        }
        return null;
    }

    // Admin-only: Update user role
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/role")
    public String updateUserRole(@PathVariable Long id, @RequestBody String role) {
        Optional<User> userOpt = userService.findUserById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setRole(UserRole.valueOf(role));  // Update role
            userService.saveUser(user);
            return "User role updated!";
        }
        return "User not found!";
    }

    // Delete user account
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

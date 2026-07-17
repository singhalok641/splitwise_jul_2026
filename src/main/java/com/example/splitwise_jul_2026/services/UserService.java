package com.example.splitwise_jul_2026.services;

import com.example.splitwise_jul_2026.exceptions.UserNotFoundException;
import com.example.splitwise_jul_2026.models.User;
import com.example.splitwise_jul_2026.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String name, String phone, String password) {
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phone);
        user.setPassword(password); // in reality, you would encrypt and store
        user.setCreatedAt(new Date());
        user.setLastModifiedAt(new Date());

        return userRepository.save(user);
    }

    public User updateProfile(Long userId, String newPassword) {
        // TODO: Implement me
        return null;
    }

    public User getUserById(Long userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User with id: " + userId + " not found");
        }

        return userOptional.get();
    }

}

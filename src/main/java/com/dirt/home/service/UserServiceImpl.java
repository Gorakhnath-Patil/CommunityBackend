// UserServiceImpl class
package com.dirt.home.service;

import com.dirt.home.dto.UserDto;
import com.dirt.home.exception.ResourceNotFoundException;
import com.dirt.home.model.User;
import com.dirt.home.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        // Implement user creation logic and return the created UserDto
        // For simplicity, I'll omit the creation logic here
        return userDto;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        // Find the user by id, update its properties, and return the updated UserDto
        // For simplicity, I'll omit the update logic here
        return userDto;
    }

    @Override
    public void deleteUser(Long id) {
        // Find the user by id and delete it
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getUserById(Long id) {
        // Find the user by id and convert it to UserDto
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapUserToUserDto).collect(Collectors.toList());
    }

    // Helper method to map User to UserDto
    private UserDto mapUserToUserDto(User user) {
        // Implement mapping code here
        // For simplicity, I'll omit the mapping code here
        return null;
    }
}

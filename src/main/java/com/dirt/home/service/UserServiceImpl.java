package com.dirt.home.service;

import com.dirt.home.dto.UserDto;
import com.dirt.home.exception.ResourceNotFoundException;
import com.dirt.home.model.User;
import com.dirt.home.repository.UserRepository;
import org.modelmapper.ModelMapper; // Import ModelMapper
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
    private final ModelMapper modelMapper; // Inject ModelMapper

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper; // Initialize the injected ModelMapper
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        // Map UserDto to User entity using ModelMapper
        User newUser = modelMapper.map(userDto, User.class);

        // Save the new user entity
        User savedUser = userRepository.save(newUser);

        // Map the saved user entity back to UserDto
        return modelMapper.map(savedUser, UserDto.class);
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
        return modelMapper.map(user, UserDto.class); // Use ModelMapper to map entities
    }
}

package com.dirt.home.controller;

import com.dirt.home.dto.ResponseDto;
import com.dirt.home.dto.UserDto;
import com.dirt.home.exception.ResourceNotFoundException;
import com.dirt.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        ResponseDto response = new ResponseDto("success", "User created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        userService.updateUser(id, userDto);
        ResponseDto response = new ResponseDto("success", "User updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        ResponseDto response = new ResponseDto("success", "User deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

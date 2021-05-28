package com.app.easy2excel.controller;

import com.app.easy2excel.dto.UserDTO;
import com.app.easy2excel.entity.User;
import com.app.easy2excel.repository.UserRepository;
import com.app.easy2excel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {

        return ResponseEntity.ok(userService.saveUser(userDTO));

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable("id") int id) {

        return ResponseEntity.ok(userService.getUserDetailsById(id));

    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUserList());

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable("id") int id,
                                               @RequestBody UserDTO userDTO) {

        return ResponseEntity.ok(userService.updateUserById(id, userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") int id) {

        userService.deleteUserById(id);
        return ResponseEntity.ok("user deleted successfully");

    }
}

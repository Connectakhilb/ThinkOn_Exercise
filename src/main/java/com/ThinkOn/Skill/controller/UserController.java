package com.ThinkOn.Skill.controller;

import com.ThinkOn.Skill.dto.UserDTO;
import com.ThinkOn.Skill.entity.User;
import com.ThinkOn.Skill.exception.NotFoundException;
import com.ThinkOn.Skill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<List<UserDTO>>(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<UserDTO>(userService.getUserById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> addUser(@RequestBody User user) {
        return new ResponseEntity<UserDTO>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id,@RequestBody UserDTO userDTO) throws NotFoundException {
        return new ResponseEntity<UserDTO>( userService.updateUserInfo(id,userDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public   String deleteUser(@PathVariable int id){
        return    userService.deleteUser(id);

    }
}
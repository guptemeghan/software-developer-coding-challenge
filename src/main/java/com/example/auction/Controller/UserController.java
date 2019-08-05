package com.example.auction.Controller;

import com.example.auction.Model.Users;
import com.example.auction.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by meghan on 8/4/2019.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public Users getUserById(@PathVariable int id) throws Exception {
        return userService.getUserById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> createUser(@RequestBody Users user) throws Exception {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
}

package com.tourism.controller.admin.api;

import com.tourism.entity.User;
import com.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User getUserByid(@PathVariable int userId){
        return userService.getUser(userId);
    }

}

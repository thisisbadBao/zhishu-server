package com.zhishu.hd.controller;

import com.zhishu.hd.model.dto.*;
import com.zhishu.hd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Object registerUser(@RequestBody Register register){
        return userService.register(register);
    }

    @PostMapping("/login")
    public Object loginUser(@RequestBody Login login){
        return userService.login(login);
    }

}

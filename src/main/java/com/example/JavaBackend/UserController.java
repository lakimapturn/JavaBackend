package com.example.JavaBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserInfo> getInformation() {
        return userService.getAllUserInfo();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/user-info")
    public void postInformation(@RequestBody UserInfo userInfo) {
        userService.addUserInfo(userInfo);
    }

    @DeleteMapping("/user-info/{id}")
    public void deleteInformation(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/user-info/{id}")
    public Optional<UserInfo> getUserInfo(@PathVariable long id) {
        return userService.getUserInfo(id);
    }

    @DeleteMapping("/user-info")
    public void deleteUserInfo() {
        userService.deleteAllUsers();
    }
}

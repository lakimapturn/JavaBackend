package com.example.JavaBackend.Controller;

import com.example.JavaBackend.Service.UserService;
import com.example.JavaBackend.UserInfo;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    private Logger log = LoggerFactory.getLogger(User.class);

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserInfo>> getInformation() {
        try {
            return new ResponseEntity(userService.getAllUserInfo(), HttpStatus.OK);
        }
        catch (Error error) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/user-info")
    public ResponseEntity<List<UserInfo>> postInformation(@RequestBody UserInfo userInfo) {
        try {
            log.info("REST request to save userinfo: {} {}", userInfo.getUsername(), userInfo.getEmail());
            userService.addUserInfo(userInfo);
            return new ResponseEntity(userService.getAllUserInfo(), HttpStatus.CREATED);
        }
        catch(Error error) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/user-info/{id}")
    public ResponseEntity<List<UserInfo>> updateInformation(@RequestBody UserInfo userInfo, @PathVariable long id) {
        try {
            userInfo.setId(id);
            userService.updateUserInfo(userInfo, id);
            return new ResponseEntity(userService.getAllUserInfo(), HttpStatus.ACCEPTED);
        }
        catch (Error error) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/user-info/{id}")
    public ResponseEntity<Void> deleteInformation(@PathVariable long id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        catch (Error error) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user-info/{id}")
    public ResponseEntity<Optional<UserInfo>> getUserInfo(@PathVariable long id) {
        try {
            return new ResponseEntity(userService.getUserInfo(id), HttpStatus.OK);
        }
        catch (Error error) {
            System.out.println(error);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/user-info")
    public ResponseEntity deleteAllUserInfo() {
        try {
            userService.deleteAllUsers();
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        catch(Error error) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

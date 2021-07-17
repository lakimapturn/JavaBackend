package com.example.JavaBackend.Service;

import com.example.JavaBackend.UserInfo;
import com.example.JavaBackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserInfo> getAllUserInfo() {
        return userRepository.findAll();
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public Optional<UserInfo> getUserInfo(long id) {
        return userRepository.findById(id);
    }

    public void updateUserInfo(UserInfo user, long id) {
        userRepository.save(user);
    }

    public void addUserInfo(UserInfo user) {
        userRepository.save(user);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public void editUserInfo(UserInfo userInfo) {

    }
}

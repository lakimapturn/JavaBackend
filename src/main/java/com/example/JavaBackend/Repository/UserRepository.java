package com.example.JavaBackend.Repository;

import com.example.JavaBackend.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
}

package com.example.demo.user;

import com.example.demo.user.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsername(UUID id);

    boolean existsByEmail(String email);

}

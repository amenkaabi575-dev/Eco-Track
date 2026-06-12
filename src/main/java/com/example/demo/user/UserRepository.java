package com.example.demo.user;

import com.example.demo.user.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query("""
            SELECT User FROM User u
            JOIN FETCH u.organization o
            WHERE o.id = :organizationId
            """)
    List<User> findUsersByOrganizationId(UUID organizationId);

    boolean existsByEmailAndIdNot(String email, UUID id);
}

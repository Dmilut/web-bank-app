package com.dmilut.webbankapp.repositories;

import com.dmilut.webbankapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Query method
    Optional<User> findByEmail(String email);
}


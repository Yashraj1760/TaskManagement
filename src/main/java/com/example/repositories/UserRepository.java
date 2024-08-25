package com.example.repositories;

import com.example.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {
    public Optional<Users> findUsersByUsername(String username);
}

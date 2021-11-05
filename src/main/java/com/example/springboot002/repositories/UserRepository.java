package com.example.springboot002.repositories;

import com.example.springboot002.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}

package com.example.pp_3_1_1_new.repository;

import com.example.pp_3_1_1_new.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

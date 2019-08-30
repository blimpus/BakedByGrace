package com.spring.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.auth.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

		List<User> findByUsernameAndPassword(String username, String password);
}

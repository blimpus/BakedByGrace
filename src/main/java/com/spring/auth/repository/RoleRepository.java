package com.spring.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

package com.spring.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.auth.model.Authority;

public interface AuthorityJpaRepository extends JpaRepository<Authority, Integer> {

}

package com.kenkosushi.Undav.domain.repository;

import com.kenkosushi.Undav.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public abstract User findByUsername(String username);
}
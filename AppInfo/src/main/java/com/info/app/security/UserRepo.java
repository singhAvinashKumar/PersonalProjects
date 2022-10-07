package com.info.app.security;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Integer> {
    public Optional<Users> findByUserName(String userName);

}

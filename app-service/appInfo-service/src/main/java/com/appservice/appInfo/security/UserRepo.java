package com.appservice.appInfo.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Integer> {
    public Optional<Users> findByUserName(String userName);

}

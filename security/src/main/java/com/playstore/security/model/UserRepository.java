package com.playstore.security.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Integer> {
    public Optional<UserInfo> findByEmail(String username);
}

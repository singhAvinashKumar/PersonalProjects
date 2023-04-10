package com.appservice.user.info;

import com.appservice.user.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserRepo extends CrudRepository<UserInfo, Integer> {
     Optional<UserInfo> findByEmail(String email);
     List<String> findByPreviousPassword(int userId);
}

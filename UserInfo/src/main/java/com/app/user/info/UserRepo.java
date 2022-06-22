package com.app.user.info;

import com.app.user.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo extends CrudRepository<UserInfo, Integer> {
}

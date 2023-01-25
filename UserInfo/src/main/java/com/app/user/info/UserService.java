package com.app.user.info;

import com.app.user.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    public Iterable<UserInfo> getAllUser() {
           return repo.findAll();
    }

    public Optional<UserInfo> getUser(int userId) {
        return repo.findById(userId);
    }

    public Optional<UserInfo> getUserByEmail(String email){
        return repo.findByEmail(email);
    }
    public boolean createUser(UserInfo user){
         repo.save(user);
         return true;
    }

    public String deleteUser(int userId){
            repo.deleteById(userId);
            return "User Removed";
    }

    public void updateUser(UserInfo info) {
            Optional<UserInfo> userInfo = repo.findById(info.getUserId());
            userInfo.ifPresentOrElse(userInfo1 -> repo.save(info),
                    ()->{
                        throw new UserNotFoundException("User "+info.getUserId()+ " not present");
                    });
    }
}

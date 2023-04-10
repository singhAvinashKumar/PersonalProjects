package com.appservice.user.info;

import com.appservice.user.model.ChangePassword;
import com.appservice.user.model.ResponseBody.Status;
import com.appservice.user.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    private PasswordEncoder encoder;
    public Iterable<UserInfo> getAllUser() {
           return repo.findAll();
    }

    public Optional<UserInfo> getUser(int userId) {
        return repo.findById(userId);
    }

    public Optional<UserInfo> getUserByEmail(String email){
        return repo.findByEmail(email);
    }
    public void createUser(UserInfo user){
        String hashId = encoder.encode(user.getPassword());
        user.setPassword(hashId);
        ArrayList<String> previousPasswords = new ArrayList<>();
        previousPasswords.add(hashId);
        user.setPreviousPassword(previousPasswords);
        repo.save(user);
    }

    public String deleteUser(int userId){
            repo.deleteById(userId);
            return "User Removed";
    }
    public Status changePassword(ChangePassword form, int userId){
        Optional<UserInfo> info = repo.findById(userId);
        String fetchPassword = null;
        if (form.getOldPassword().equals(form.getNewPassword()))
            return new Status(2180,"Old and New are same",HttpStatus.BAD_REQUEST);
        if (info.isEmpty())
            return new Status(2145,"User Doesn't exist", HttpStatus.BAD_REQUEST);
        fetchPassword = info.get().getPassword();

        if (!encoder.matches(form.getOldPassword(),fetchPassword))
            return new Status(2170,"Invalid Password", HttpStatus.BAD_REQUEST);

        List<String> byPreviousPassword = info.get().getPreviousPassword();
        String finalFetchPassword = fetchPassword;
        if (byPreviousPassword.stream().anyMatch(hash -> encoder.matches(finalFetchPassword,hash)))
            return new Status(2170,"Password used Recently",HttpStatus.NOT_ACCEPTABLE);

        info.get().setPassword(encoder.encode(form.getNewPassword()));
        if (byPreviousPassword.size()>=5)
            byPreviousPassword.remove(0);
        byPreviousPassword.add(encoder.encode(form.getNewPassword()));
        repo.save(info.get());
        return new Status(0,"Password Updated",HttpStatus.OK);
    }



    public void updateUser(UserInfo info) {
            Optional<UserInfo> userInfo = repo.findById(info.getUserId());
            userInfo.ifPresentOrElse(userInfo1 -> repo.save(info),
                    ()->{
                        throw new UserNotFoundException("User "+info.getUserId()+ " not present");
                    });
    }
}

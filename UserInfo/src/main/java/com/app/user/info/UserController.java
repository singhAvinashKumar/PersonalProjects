package com.app.user.info;

import com.app.user.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //Get All User Info
    @RequestMapping("/")
    public Iterable<UserInfo> getAllUser(){
        return userService.getAllUser();
    }

    //Get User with given userId
    @RequestMapping("/{userId}")
    public Optional<UserInfo> getUser(@PathVariable int userId){
        Optional<UserInfo> temp=userService.getUser(userId);
        if (temp.isEmpty()){

            throw new UserNotFoundException("User ID"+userId);
        }
        return temp;
    }

    //Create User
    @RequestMapping(method = RequestMethod.POST,value = "/")
    public String createUser(@RequestBody UserInfo info ){
       return userService.createUser(info);
    }

    //Update User takes UserID
    @RequestMapping(method = RequestMethod.PUT,value = "/{userId}")
    public String updateUser (@RequestBody UserInfo info,@PathVariable int userId){
        return userService.createUser(info);
    }

    //Delete User takes UserId
    @RequestMapping(method = RequestMethod.DELETE,value = "/{userId}")
    public String deleteUser(@PathVariable int userId){
        return userService.deleteUser(userId);
    }
}

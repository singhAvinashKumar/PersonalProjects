package com.playstore.security.configuration;


import com.playstore.security.model.UserInfo;
import com.playstore.security.model.UserNotFoundException;
import com.playstore.security.model.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayStoreUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private static Logger logger = LoggerFactory.getLogger(PlayStoreUserService.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userRepository.findByEmail(username);
        userInfo.orElseThrow(()-> new UserNotFoundException(username));
        logger.info("loadUserName Called "+ userInfo.get().toString());
        PlayStoreUserDetails playStoreUserDetails = userInfo.map(PlayStoreUserDetails::new).get();
        logger.info("UserName: "+playStoreUserDetails.getUsername()+" Password: "+ playStoreUserDetails.getPassword());
        return playStoreUserDetails;
    }
}

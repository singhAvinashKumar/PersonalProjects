package com.playstore.security.configuration;

import com.playstore.security.model.UserInfo;
import com.playstore.security.model.UserNotFoundException;
import com.playstore.security.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayStoreUserDetails implements UserDetails {


    private int userId;
   // private String email;
    private String password;
    private String userName;
    private List<GrantedAuthority> authorities;

    public PlayStoreUserDetails(UserInfo userInfo) {
        this.userId = userInfo.getUserId();
     //   this.email = userInfo.getEmail();
        this.password = userInfo.getPassword();
        this.userName = userInfo.getEmail();
        this.authorities = Stream.of(userInfo.getRole())
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());
    }

    public int getUserId() {
        return userId;
    }

  /*  public String getEmail() {
        return email;
    }

*/    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.parking.account.service;

import com.parking.account.domain.User;
import com.parking.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jitendra Dafda on 1/26/16.
 */

@Service
public class UserService {


    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserWithAuthorities() {
        // need to implement security
        return userRepository.findOneByEmail("abc.yyy@gmail.com").get();
    }
}

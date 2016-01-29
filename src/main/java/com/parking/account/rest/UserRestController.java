package com.parking.account.rest;

import com.parking.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jitendra Dafda on 1/26/16.
 */
@RestController
@RequestMapping("parking/v1")
public class UserRestController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void getUser() {
        userService.getUserWithAuthorities();
    }
}

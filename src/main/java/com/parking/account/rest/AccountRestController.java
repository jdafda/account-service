package com.parking.account.rest;

import com.parking.account.rest.dto.UserDTO;
import com.parking.account.service.AccountService;
import com.parking.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by Jitendra Dafda on 1/21/16.
 */

@RestController
@RequestMapping(value = "/parking/v1")
public class AccountRestController {

    private AccountService accountService;

    private UserService userService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> createAccount(@RequestBody UserDTO userDTO) {
        accountService.createAccount(userDTO.getEmail(), userDTO.getFirstName(),
                userDTO.getLastName(), userDTO.getPassword());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/account",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getAccount() {
        return Optional.ofNullable(userService.getUserWithAuthorities())
                .map(user -> {
                    return new ResponseEntity<>(
                            new UserDTO(
                                    user.getEmail(),
                                    user.getFirstName(),
                                    user.getLatName(),
                                    null),
                            HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }


}

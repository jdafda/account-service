package com.parking.account.service;

import com.parking.account.domain.User;
import com.parking.account.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jitendra Dafda on 1/21/16.
 */
@Service
public class AccountService {

    private final Logger log = LoggerFactory.getLogger(AccountService.class);

    private AccountRepository accountRepository;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public User createAccount(String email, String firstName,
                              String lastName, String password) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setFirstName(firstName);
        newUser.setLatName(lastName);
        newUser.setPassword(password);
        accountRepository.save(newUser);
        log.debug("Created account for User: {}" + newUser);
        return newUser;
    }
}

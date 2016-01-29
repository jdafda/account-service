package com.parking.account.repository;

import com.parking.account.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by Jitendra Dafda on 1/21/16.
 */
public interface AccountRepository extends MongoRepository<User, Long> {

}

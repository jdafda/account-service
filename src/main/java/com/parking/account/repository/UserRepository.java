package com.parking.account.repository;

import com.parking.account.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by Jitendra Dafda on 1/26/16.
 */

public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findOneByEmail(String email);

}

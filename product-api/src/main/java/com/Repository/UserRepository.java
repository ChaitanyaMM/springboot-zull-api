package com.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Eyedentify.User;

public interface UserRepository extends MongoRepository<User, Long> {

}

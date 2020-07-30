package com.natan.mongoproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.natan.mongoproject.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
}

package com.ottclone.userEntity;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepo extends MongoRepository<User, String> {
		Optional<User> findByusername(String name);
}

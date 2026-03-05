package com.ottclone.userEntity;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User findByUsername(String username) {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public Optional<User> findById(String id) {
        return userRepo.findById(id);
    }

	public ResponseEntity<Object> deleteById(String id) {
		
		userRepo.deleteById(id);
		return ResponseEntity.ok().build();
	}

	
}
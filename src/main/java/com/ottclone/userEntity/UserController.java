package com.ottclone.userEntity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/username/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }
    
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userService.findById(id);
    }
    
    

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }
    
    @DeleteMapping("deleteuser/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		userService.deleteById(id);	
		return ResponseEntity.ok().build();
	}
   
}
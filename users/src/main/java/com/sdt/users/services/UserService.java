package com.sdt.users.services;

import com.sdt.users.User;
import com.sdt.users.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public void registerUser(User user){
        User existingUser = userRepository.findByUsername(user.getUsername());

        if(existingUser != null){
            throw new IllegalStateException("Username already taken");
        }

        userRepository.save(user);
    }

    public String loginUser(User user){
        User existingUser = userRepository.findByUsername(user.getUsername());

        if(existingUser == null){
            throw new IllegalStateException("User not found");
        }

        if(!existingUser.getPassword().equals(user.getPassword())){
            throw new IllegalStateException("Invalid password");
        }

        return jwtService.generateToken(existingUser.getUsername());


    }



}

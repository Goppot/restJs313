package com.example.restJs.service;

import com.example.restJs.model.User;
import com.example.restJs.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<User> getAll(){
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getByUSerId(int id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getShowId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(getByUSerId(user.getId()));
    }
}



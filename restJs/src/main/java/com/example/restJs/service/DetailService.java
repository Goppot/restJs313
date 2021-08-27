package com.example.restJs.service;

import com.example.restJs.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailService implements UserDetailsService {

    final
    UserRepository userRepository;

    public DetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }
}

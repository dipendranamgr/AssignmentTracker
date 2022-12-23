package com.codecamp.SubmitAssignment.service;

import com.codecamp.SubmitAssignment.domain.Users;
import com.codecamp.SubmitAssignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("finding username");
        Optional<Users> user = userRepository.findByUsername(username);
        /*Users user = new Users();
        user.setUsername(username);
        user.setPassword("$2a$12$4UQ4zqTrXIbwU7Xb9NuelO6PeGpHY77jQ4T8AvPQPB5i7H2QiMMlO");
        user.setId(1L);*/
        return user.orElseThrow(()-> new UsernameNotFoundException("Invalid information provided"));
    }
}



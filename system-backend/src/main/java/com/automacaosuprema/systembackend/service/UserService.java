package com.automacaosuprema.systembackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.automacaosuprema.systembackend.entities.UserModel;
import com.automacaosuprema.systembackend.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUserName(username).orElse(null);
        if (user == null) {
            logger.error("username not found: " + username);
            throw new UsernameNotFoundException("username not found");
        }
        logger.info("username found: " + username);
        UserDetails userDetails = User.withUsername(user.getUsername()).password(user.getPassword())
                .authorities("admin").build();
        return userDetails;
    }

}

package com.automacaosuprema.systembackend.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automacaosuprema.systembackend.dto.UserRoleDTO;
import com.automacaosuprema.systembackend.entities.Role;
import com.automacaosuprema.systembackend.entities.UserModel;
import com.automacaosuprema.systembackend.repositories.UserRepository;

@Service
public class createRoleUserService {

    @Autowired
    UserRepository userRepository;

    public UserModel createRoleUser(UserRoleDTO userRoleDTO) {

        Optional<UserModel> userExists = userRepository.findById(userRoleDTO.getUserId());
        Set<Role> roles = new HashSet<>();

        if (userExists.isEmpty()) {
            throw new Error("User not found");
        }

        roles = userRoleDTO.getRolesId().stream().map(role -> {
            return new Role(role);
        }).collect(Collectors.toSet());

        UserModel user = userExists.get();

        user.setRoles(roles);

        userRepository.save(user);

        return user;

    }

}

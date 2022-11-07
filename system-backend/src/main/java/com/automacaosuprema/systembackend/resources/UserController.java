package com.automacaosuprema.systembackend.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.automacaosuprema.systembackend.dto.UserRoleDTO;
import com.automacaosuprema.systembackend.entities.UserModel;
import com.automacaosuprema.systembackend.repositories.UserRepository;
import com.automacaosuprema.systembackend.service.createRoleUserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    createRoleUserService createRoleUserService;

    @GetMapping
    public ResponseEntity<List<UserModel>> findAll() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserModel> findById(@PathVariable Long id) {
        UserModel obj = userRepository.findById(id).get();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/createUserRole")
    public ResponseEntity<UserModel> giveRole(@RequestBody UserRoleDTO userRoleDTO) {
        return ResponseEntity.ok().body(createRoleUserService.createRoleUser(userRoleDTO));
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserModel> save(@RequestBody UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok().body(userRepository.save(user));
    }

    @PostMapping("/validatePasswd")
    public ResponseEntity<Boolean> ValidatePasswd(@RequestParam String userName, @RequestParam String password) {
        Optional<UserModel> optUser = userRepository.findByUserName(userName);
        if (optUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean isValid = passwordEncoder.matches(password, optUser.get().getPassword());

        HttpStatus status = isValid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(isValid);

    }
}

package com.automacaosuprema.systembackend.resources;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.automacaosuprema.systembackend.entities.UserModel;
import com.automacaosuprema.systembackend.service.TokenService;

@RestController
public class AuthController {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public Map<String, String> token(@RequestBody UserModel userLogin) throws AuthenticationException {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
        String token = tokenService.generateToken(authentication);
        return Collections.singletonMap("token", token);
    }
}

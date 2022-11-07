package com.automacaosuprema.systembackend.resources;

import java.security.Principal;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = authentication.getAuthorities().stream()
                .map(r -> r.getAuthority()).collect(Collectors.toSet());
        return "Hello, " + principal.getName() + "!" + roles;
    }

    @PreAuthorize("hasAuthority('SCOPE_admin')")
    @GetMapping("/secure")
    public String secure() {
        return "This is secured!";
    }
}

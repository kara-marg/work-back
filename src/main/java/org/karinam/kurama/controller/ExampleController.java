package org.karinam.kurama.controller;

import org.karinam.kurama.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {
    private final UserService service;

    @GetMapping
    public String example() {
        return "Hello, world!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String exampleAdmin() {
        return "Hello, admin!";
    }

    @GetMapping("/get-admin")
    public void getAdmin() {
        service.getAdmin();
    }
}
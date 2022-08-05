package com.example.item.controller;

import com.example.item.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController("/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> sayHallo(){
        return ResponseEntity.ok("Hello");
    }


}

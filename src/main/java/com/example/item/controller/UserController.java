package com.example.item.controller;

import com.example.item.domain.JwtRequest;
import com.example.item.domain.JwtResponse;
import com.example.item.domain.User;
import com.example.item.dto.UserDto;
import com.example.item.service.JwtService;
import com.example.item.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("/v1/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Lazy
    @Autowired
    private JwtService jwtService;

    @PostMapping({"logIn"})
    public ResponseEntity<JwtResponse> createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return ResponseEntity.ok(jwtService.createJwtToken(jwtRequest));
    }

    @PostMapping("register")
    public ResponseEntity<Void> register(@RequestBody UserDto userDto) {
        User user = userService.register(userDto);
        return ResponseEntity.ok().build();
    }
}

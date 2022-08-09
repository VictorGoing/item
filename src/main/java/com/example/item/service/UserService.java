package com.example.item.service;

import com.example.item.domain.User;
import com.example.item.dto.UserDto;
import com.example.item.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(UserDto userDto) {
        User user = new User(userDto.getLogin(), getEncodedPassword(userDto.getPassword()));
        return userRepository.save(user);
    }

    public User getUserByUserLogin(String userLogin) {
        return userRepository.findByLogin(userLogin);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

}

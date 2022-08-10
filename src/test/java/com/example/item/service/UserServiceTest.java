package com.example.item.service;

import com.example.item.domain.Item;
import com.example.item.domain.User;
import com.example.item.dto.UserDto;
import com.example.item.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRegister() {
        //Given
        UserDto userDto = new UserDto("registerTest", "registerTest");

        //When
        userService.register(userDto);

        //Then
        User user = userRepository.findByLogin("registerTest");
        Assertions.assertEquals(user.getLogin(), "registerTest");

        //CleanUp
        userRepository.deleteById(user.getId());
    }

    @Test
    public void testGetUserByUserLogin() {
        //Given
        User userExample = new User("registerTest", "registerTest");
        userRepository.save(userExample);

        //When
        User user = userService.getUserByUserLogin("registerTest");

        //Then
        Assertions.assertEquals(user.getLogin(), "registerTest");

        //CleanUp
        userRepository.deleteByLogin("registerTest");
    }
}

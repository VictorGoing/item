package com.example.item.service;

import com.example.item.domain.Item;
import com.example.item.domain.User;
import com.example.item.dto.UserDto;
import com.example.item.repository.ItemRepository;
import com.example.item.repository.UserRepository;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddItem() {
        //Given
        User user = userService.register(new UserDto("addItemTest", "addItemTest"));

        //When
        itemService.addItem("addItemTest", user);

        //Then
        Item item = itemRepository.findByName("addItemTest");
        Assertions.assertEquals(item.getName(), "addItemTest");

        //CleanUp
        itemRepository.deleteByName("addItemTest");
        userRepository.deleteByLogin("addItemTest");

    }

    @Test
    public void testGetUserItems() {
        //Given
        User user = userService.register(new UserDto("addItemTest", "addItemTest"));
        itemService.addItem("addItemTest1", user);
        itemService.addItem("addItemTest2", user);
        itemService.addItem("addItemTest3", user);
        Long userId = userService.getUserByUserLogin("addItemTest").getId();
        //When
        List<Item> list = itemService.getUserItems(userId);

        //Then
        Assertions.assertEquals(list.size(), 3);
        Assertions.assertEquals(list.get(0).getName(), "addItemTest1");
        Assertions.assertEquals(list.get(1).getName(), "addItemTest2");
        Assertions.assertEquals(list.get(2).getName(), "addItemTest3");

        //CleanUp
        itemRepository.deleteByName("addItemTest1");
        itemRepository.deleteByName("addItemTest2");
        itemRepository.deleteByName("addItemTest3");
        userRepository.deleteByLogin("addItemTest");
    }
}

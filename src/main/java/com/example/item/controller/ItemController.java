package com.example.item.controller;

import com.example.item.domain.Item;
import com.example.item.domain.User;
import com.example.item.dto.ItemDto;
import com.example.item.service.ItemService;
import com.example.item.service.UserService;
import com.example.item.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/items")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createItem(@RequestBody ItemDto itemDto, @RequestHeader(value = "Authorization") String jwtToken) {
        String userLogin = jwtUtil.getUserNameFromToken(jwtToken.substring(7));
        User user = userService.getUserByUserLogin(userLogin);
        itemService.addItem(itemDto.getName(), user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Item>> getUserItems(@RequestHeader(value = "Authorization") String jwtToken) {
        String userLogin = jwtUtil.getUserNameFromToken(jwtToken.substring(7));
        Long userId = userService.getUserByUserLogin(userLogin).getId();
        return ResponseEntity.ok(itemService.getUserItems(userId));
    }
}

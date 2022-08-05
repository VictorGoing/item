package com.example.item.controller;

import com.example.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/v1/items")
public class ItemController {

    private final ItemService itemService;


}

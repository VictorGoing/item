package com.example.item.service;

import com.example.item.domain.Item;
import com.example.item.domain.User;
import com.example.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void addItem(String itemName, User user) {
        Item item = new Item(user.getId(), itemName);
        itemRepository.save(item);
    }

    public List<Item> getUserItems(Long userId) {
        return itemRepository.findItemsByOwner(userId);
    }
}

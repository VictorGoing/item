package com.example.item.service;

import com.example.item.domain.Item;
import com.example.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> getUserItems(Long ownerId) {
        return itemRepository.findItemsByOwner(ownerId);
    }
}

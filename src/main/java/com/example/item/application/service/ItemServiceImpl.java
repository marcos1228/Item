package com.example.item.application.service;

import com.example.item.application.port.ItemService;
import com.example.item.domain.dto.ItemDto;
import com.example.item.domain.model.Item;
import com.example.item.domain.repository.ItemRepository;
import com.example.item.framework.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private  ItemRepository itemRepository;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Mono<ItemDto> create(ItemDto itemDto) {
        Item item = itemMapper.toItem(itemDto);
        return itemRepository.save(item)
                .map(savedItem -> itemMapper.toItemDto(savedItem));
    }

    @Override
    public Flux<ItemDto> getAll() {
        return itemRepository.findAll()
                .map(getdItem -> itemMapper.toItemDto(getdItem));
    }

    @Override
    public Mono<ItemDto> getById(String id) {
        return itemRepository.findById(id).map(findItem -> itemMapper.toItemDto(findItem));
    }

    @Override
    public Mono<Object> update(String id, ItemDto itemDto) {
        Mono<Item> byId = itemRepository.findById(id);


        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
         return itemRepository.deleteById(id);
    }
}

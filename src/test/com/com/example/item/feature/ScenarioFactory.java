package com.com.example.item.feature;

import com.example.item.domain.dto.ItemDto;
import com.example.item.domain.model.Item;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public class ScenarioFactory {
    public ItemDto getItemDto(){
        ItemDto itemDto = new ItemDto();
        itemDto.setName("teste");
        itemDto.setDescription("teste unitário");
        itemDto.setQuantity(10);
        itemDto.setPrice(BigDecimal.valueOf(1));
        return itemDto;
    }
    public Mono<Item> getItem(){
        Item item = new Item();
        item.setName("teste");
        item.setDescription("teste unitário");
        item.setQuantity(10);
        item.setPrice(BigDecimal.valueOf(1));
        return Mono.just(item);
    }

    public Mono<Item> savedItem(){
        Item item = new Item();
        item.setName("teste");
        item.setDescription("teste unitário");
        item.setQuantity(10);
        item.setPrice(BigDecimal.valueOf(1));
        return Mono.just(item);
    }
}

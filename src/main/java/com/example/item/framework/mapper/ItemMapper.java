package com.example.item.framework.mapper;

import com.example.item.domain.dto.ItemDto;
import com.example.item.domain.model.Item;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ItemMapper {
    public ItemDto toItemDto(Item entity){
        ItemDto itemDto = new ItemDto();
        itemDto.setName(entity.getName());
        itemDto.setDescription(entity.getDescription());
        itemDto.setPrice(entity.getPrice());
        itemDto.setQuantity(entity.getQuantity());
        return  itemDto;
    }

    public Item toItem(ItemDto entity){
        Item item = new Item();
        item.setName(entity.getName());
        item.setDescription(entity.getDescription());
        item.setPrice(entity.getPrice());
        item.setQuantity(entity.getQuantity());
        return  item;
    }
}

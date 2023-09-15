package com.example.item.feature;

import com.example.item.domain.dto.ItemDto;
import com.example.item.domain.model.Item;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public class ScenarioFactory {
    public static  ItemDto inputDto(){
        ItemDto inputDto = new ItemDto();
        inputDto.setName("Produto A");
        inputDto.setDescription("Produto de cozinha");
        inputDto.setPrice(BigDecimal.valueOf(1));
        inputDto.setQuantity(Integer.valueOf(1));
        return inputDto;
    }
    public static  Item itemAfterConversion(){
        Item itemAfterConversion = new Item();
        itemAfterConversion.setName("Produto A");
        itemAfterConversion.setDescription("Produto de cozinha");
        itemAfterConversion.setPrice(BigDecimal.valueOf(1));
        itemAfterConversion.setQuantity(Integer.valueOf(1));
        return itemAfterConversion;
    }

    public static  Item savedItem(){
        Item savedItem = new Item();
        savedItem.setId("1");
        savedItem.setName("Produto A");
        savedItem.setDescription("Produto de cozinha");
        savedItem.setPrice(BigDecimal.valueOf(1));
        savedItem.setQuantity(Integer.valueOf(1));
        return savedItem;
    }
}

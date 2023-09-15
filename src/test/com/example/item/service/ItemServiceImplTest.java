package com.example.item.service;

import com.example.item.feature.ScenarioFactory;
import com.example.item.application.service.ItemServiceImpl;
import com.example.item.domain.dto.ItemDto;
import com.example.item.domain.model.Item;
import com.example.item.domain.repository.ItemRepository;
import com.example.item.framework.mapper.ItemMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import reactor.core.publisher.Mono;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
public class ItemServiceImplTest {
    @InjectMocks
    private ItemServiceImpl itemService;
    @Mock
    private ItemRepository itemRepository;
    @Mock
    private ScenarioFactory scenarioFactory;
    @Mock
    private ItemMapper itemMapper;

    

    @Test
    public void Should_Create_Item_Success(){
        when(itemRepository.save(any(Item.class))).thenReturn(scenarioFactory.savedItem());
        Mono<ItemDto> itemDtoMono = itemService.create(scenarioFactory.getItemDto());
        assertEquals(1,scenarioFactory.getItem());

    }
}
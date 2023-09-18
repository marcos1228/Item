package com.example.item.service.unitario;

import com.example.item.application.service.ItemServiceImpl;
import com.example.item.domain.dto.ItemDto;
import com.example.item.domain.model.Item;
import com.example.item.domain.repository.ItemRepository;
import com.example.item.framework.mapper.ItemMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ItemServiceImplMutantesTest {
    @InjectMocks
    private ItemServiceImpl itemService;
    @Mock
    private ItemRepository itemRepository;
    @Mock
    private ItemMapper itemMapper;
    @Test
    public void testCreateMutation() {
        var inputDto = new ItemDto();
        inputDto.setName("Produto A");
        inputDto.setDescription("Produto de cozinha");
        inputDto.setPrice(BigDecimal.valueOf(1));
        inputDto.setQuantity(Integer.valueOf(1));

        var itemAfterConversion = new Item();
        itemAfterConversion.setName("Produto A");
        itemAfterConversion.setDescription("Produto de cozinha");
        itemAfterConversion.setPrice(BigDecimal.valueOf(1));
        itemAfterConversion.setQuantity(Integer.valueOf(1));

        var savedItem = new Item();
        savedItem.setId("1");
        savedItem.setName("Produto A");
        savedItem.setDescription("Produto de cozinha");
        savedItem.setPrice(BigDecimal.valueOf(1));
        savedItem.setQuantity(Integer.valueOf(1));

        when(itemMapper.toItem(inputDto)).thenReturn(itemAfterConversion);
        when(itemRepository.save(itemAfterConversion)).thenReturn(Mono.empty());
//        when(itemMapper.toItemDto(savedItem)).thenReturn(inputDto);
        // Introduza uma mutação de negação condicional

        // when(itemMapper.toItemDto(item)).thenReturn(itemDto);

        Mono<ItemDto> result = itemService.create(inputDto);

        // Verifique se o resultado é nulo devido à mutação
        assertNull(result.block());
    }
}

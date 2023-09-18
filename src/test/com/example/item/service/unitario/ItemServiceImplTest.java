package com.example.item.service.unitario;

import com.example.item.application.service.ItemServiceImpl;
import com.example.item.domain.dto.ItemDto;
import com.example.item.domain.model.Item;
import com.example.item.domain.repository.ItemRepository;
import com.example.item.framework.mapper.ItemMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemServiceImplTest {
    @InjectMocks
    private ItemServiceImpl itemService;
    @Mock
    private ItemRepository itemRepository;
    @Mock
    private ItemMapper itemMapper;

    @Test
    public void Should_Create_Item_Success() {
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
        when(itemRepository.save(itemAfterConversion)).thenReturn(Mono.just(savedItem));
        when(itemMapper.toItemDto(savedItem)).thenReturn(inputDto);

        var result = itemService.create(inputDto);

        StepVerifier.create(result)
                .expectNext(inputDto)

                .verifyComplete();
        verify(itemMapper, times(1)).toItem(inputDto);
        verify(itemRepository, times(1)).save(itemAfterConversion);
        verify(itemMapper, times(1)).toItemDto(savedItem);
    }

    @Test
    public void Should_getAll_Item_Success() {
        Item item1 = new Item();
        item1.setId("1");
        item1.setName("Produto A");
        item1.setDescription("Produto para casa");
        item1.setPrice(BigDecimal.valueOf(1));
        item1.setQuantity(Integer.valueOf(1));


        Item item2 = new Item();
        item2.setId("2");
        item2.setName("Produto B");
        item2.setDescription("Produto para casa");
        item2.setPrice(BigDecimal.valueOf(1));
        item2.setQuantity(Integer.valueOf(1));

        // Crie os DTOs correspondentes para os itens
        ItemDto itemDto1 = new ItemDto();
        itemDto1.setName("Produto A");
        itemDto1.setDescription("Produto para casa");
        itemDto1.setPrice(BigDecimal.valueOf(1));
        itemDto1.setQuantity(Integer.valueOf(1));

        ItemDto itemDto2 = new ItemDto();
        itemDto2.setName("Produto B");
        itemDto2.setDescription("Produto para casa");
        itemDto2.setPrice(BigDecimal.valueOf(1));
        itemDto2.setQuantity(Integer.valueOf(1));

        when(itemRepository.findAll()).thenReturn(Flux.just(item1, item2));
        when(itemMapper.toItemDto(item1)).thenReturn(itemDto1);
        when(itemMapper.toItemDto(item2)).thenReturn(itemDto2);

        Flux<ItemDto> result = itemService.getAll();

        StepVerifier.create(result)
                .expectNext(itemDto1)
                .expectNext(itemDto2)
                .verifyComplete();
        verify(itemRepository, times(1)).findAll();
        verify(itemMapper, times(1)).toItemDto(item1);
        verify(itemMapper, times(1)).toItemDto(item2);
    }

    @Test
    public void Should_getById_Item_Success() {
        var itemId = "65020851c9bcab37579fb161";

        var item = new Item();
        item.setId(itemId);
        item.setName("Produto A");
        item.setDescription("Produto para casa");
        item.setPrice(BigDecimal.valueOf(1));
        item.setQuantity(Integer.valueOf(1));

        // Crie um DTO correspondente para o item
        var itemDto = new ItemDto();
        itemDto.setName("Produto A");
        itemDto.setDescription("Produto para casa");
        itemDto.setPrice(BigDecimal.valueOf(1));
        itemDto.setQuantity(Integer.valueOf(1));

        when(itemRepository.findById(itemId)).thenReturn(Mono.just(item));
        when(itemMapper.toItemDto(item)).thenReturn(itemDto);

        var result = itemService.getById(itemId);

        StepVerifier.create(result)
                .expectNext(itemDto)
                .verifyComplete();
        verify(itemRepository, times(1)).findById(itemId);
        verify(itemMapper, times(1)).toItemDto(item);
    }

    @Test
    public void Should_update_Item_Success() {
        var itemId = "65020851c9bcab37579fb161";
        ItemDto updatedItemDto = new ItemDto();
        updatedItemDto.setName("Produto B");
        updatedItemDto.setDescription("Produto para casa");
        updatedItemDto.setPrice(BigDecimal.valueOf(1));
        updatedItemDto.setQuantity(Integer.valueOf(1));

        var existingItem = new Item();
        existingItem.setId(itemId);
        existingItem.setName("Produto A");
        existingItem.setDescription("Teste");
        existingItem.setPrice(BigDecimal.valueOf(10));
        existingItem.setQuantity(Integer.valueOf(100));


        when(itemRepository.findById(itemId)).thenReturn(Mono.just(existingItem));
        when(itemMapper.toItemDto(existingItem)).thenReturn(updatedItemDto);
        when(itemRepository.save(existingItem)).thenReturn(Mono.just(existingItem));

        var result = itemService.update(itemId, updatedItemDto);

        StepVerifier.create(result)
                .expectNext(updatedItemDto)
                .verifyComplete();

        verify(itemRepository, times(1)).findById(itemId);
        verify(itemMapper, times(1)).toItemDto(existingItem);
        verify(itemRepository, times(1)).save(existingItem);

    }

    @Test
    public void Should_delete_Item_Success() {
        var itemId = "65020851c9bcab37579fb161";

        when(itemRepository.deleteById(itemId)).thenReturn(Mono.empty());

        var result = itemService.delete(itemId);

        StepVerifier.create(result)
                .verifyComplete();
        verify(itemRepository).deleteById(itemId);
    }

}

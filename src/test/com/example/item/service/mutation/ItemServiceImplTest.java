package com.example.item.service.mutation;

import com.example.item.application.service.ItemServiceImpl;
import com.example.item.domain.dto.ItemDto;
import com.example.item.domain.model.Item;
import com.example.item.framework.mapper.ItemMapper;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemServiceImplTest {
    @Mock
    private  ItemMapper itemMapper;
    @Test
    public void testCreateMutation() {
        // Crie um objeto ItemDto de amostra para o teste
        ItemDto itemDto = new ItemDto();
        itemDto.setName("");
        itemDto.setQuantity(1);
        itemDto.setDescription("teste");
        itemDto.setPrice(BigDecimal.valueOf(1));
        ItemServiceImpl itemService = new ItemServiceImpl();
       // ItemMapper itemMapper = new ItemMapper();

        // Chame o método create para criar o item
        Mono<ItemDto> createdItemMono = itemService.create(itemDto);


        // Obtenha o valor do Mono
        ItemDto createdItem = createdItemMono.block();

        // Verifique se o item criado é igual ao item de entrada
        assertEquals(itemDto, createdItem);

//        // Teste de mutação: Verifique se o item não é igual a null
//        assertNotEquals(null, createdItem);
//
//        // Teste de mutação: Verifique se o item não é igual a uma string vazia
//        assertNotEquals("", createdItem.getName());
    }

}

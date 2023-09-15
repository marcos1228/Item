package com.example.item.application.port;

import com.example.item.domain.dto.ItemDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemService {
    Mono<ItemDto> create(ItemDto itemDto);
    Flux<ItemDto> getAll();
    Mono<ItemDto> getById(String id);
    Mono<ItemDto> update(String id, ItemDto itemDto);
    Mono<Void> delete(String id);
}

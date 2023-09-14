package com.example.item.framework.controller;

import com.example.item.application.port.ItemService;
import com.example.item.domain.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("itens")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public ResponseEntity<Flux<ItemDto>> getTodosItens() {
        Flux<ItemDto> all = itemService.getAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<ItemDto>> getItemPorId(@PathVariable String id) {
        Mono<ItemDto> byId = itemService.getById(id);
        return ResponseEntity.ok().body(byId);
    }

    @PostMapping("/")
    public ResponseEntity<Mono<ItemDto>> criarItem(@RequestBody ItemDto itemDto) {
        Mono<ItemDto> itemDtoMono = itemService.create(itemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemDtoMono);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<ItemDto>> atualizarItem(@PathVariable String id, @RequestBody ItemDto item) {
        Mono<ItemDto> update = itemService.update(id, item);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deletarItem(@PathVariable String id) {
        Mono<Void> delete = itemService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(delete);
    }
}

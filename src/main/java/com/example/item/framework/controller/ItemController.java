package com.example.item.framework.controller;

import com.example.item.application.port.ItemService;
import com.example.item.domain.dto.ItemDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/itens")
@Api(value = "Item Controller", description = "APIs para operações relacionadas a itens")
public class ItemController {
    @Autowired
    private ItemService itemService;

//    @GetMapping("/")
//    public Flux<Item> getTodosItens() {
//        return itemRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Mono<Item> getItemPorId(@PathVariable String id) {
//        return itemRepository.findById(id);
//    }

    @PostMapping("/")
    @ApiOperation(value = "Cria um novo item", notes = "Este endpoint cria um novo item na base de dados.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Item criado com sucesso"),
            @ApiResponse(code = 400, message = "Solicitação inválida")
    })
    public ResponseEntity<Mono<ItemDto>> criarItem(@RequestBody ItemDto itemDto) {
        Mono<ItemDto> itemDtoMono = itemService.create(itemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemDtoMono);
    }

//    @PutMapping("/{id}")
//    public Mono<Item> atualizarItem(@PathVariable String id, @RequestBody Item item) {
//        return itemRepository.findById(id)
//                .flatMap(itemExistente -> {
//                    itemExistente.setNome(item.getNome());
//                    return itemRepository.save(itemExistente);
//                });
//    }
//
//    @DeleteMapping("/{id}")
//    public Mono<Void> deletarItem(@PathVariable String id) {
//        return itemRepository.deleteById(id);
//    }
}

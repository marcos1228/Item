package com.example.item.domain.repository;

import com.example.item.domain.model.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ItemRepository extends ReactiveMongoRepository<Item, String> {
}

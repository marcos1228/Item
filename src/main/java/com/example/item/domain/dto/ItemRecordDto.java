package com.example.item.domain.dto;

import java.math.BigDecimal;

 public record ItemRecordDto(String name, String description, BigDecimal price, int quantity){
  public ItemRecordDto(String name, String description, BigDecimal price, int quantity) {
   this.name = name;
   this.description = description;
   this.price = price;
   this.quantity = quantity;
  }
 }

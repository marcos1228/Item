package com.example.item.domain.dto;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class ItemDto {
   // public record ItemDto(String name, String description, BigDecimal price, int quantity)
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;

    public ItemDto(String name, String description, BigDecimal price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public ItemDto() {
    }

    public ItemDto(String name, String description) {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

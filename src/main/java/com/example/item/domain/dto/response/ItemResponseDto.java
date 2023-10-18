package com.example.item.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ItemResponseDto (  @JsonProperty("status") int status,
                                 @JsonProperty("timestamp") LocalDateTime at){

}

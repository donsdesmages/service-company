package com.service.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DefaultResponseDto {
    private LocalDateTime date;
    private  String body;
    private String errorMessage;
}

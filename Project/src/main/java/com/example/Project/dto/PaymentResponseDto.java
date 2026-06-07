package com.example.Project.dto;

import lombok.Data;

@Data
public class PaymentResponseDto {
    private Long id;
    private Double amount;
    private String status;
}

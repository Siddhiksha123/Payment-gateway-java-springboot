package com.example.Project.dto;

import lombok.Data;

@Data
public class PaymentRequestDto {
    private Double amount;
    // The user should not be able to set the ID or Status manually during a request
}

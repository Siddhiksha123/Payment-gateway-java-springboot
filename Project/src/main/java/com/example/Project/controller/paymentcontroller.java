package com.example.Project.controller;

import com.example.Project.dto.PaymentRequestDto;
import com.example.Project.dto.PaymentResponseDto;
import com.example.Project.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class paymentcontroller {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public PaymentResponseDto processPayment(@RequestBody PaymentRequestDto requestDto) {
        return paymentService.processPayment(requestDto);
    }

    @GetMapping("/{id}")
    public PaymentResponseDto getPayment(@PathVariable Long id) {
        return paymentService.getPaymentDetails(id);
    }

    @GetMapping("/search")
    public List<PaymentResponseDto> searchPayments(@RequestParam String status) {
        return paymentService.getPaymentsByStatus(status);
    }
}

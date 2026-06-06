package com.example.Project.controller;

import com.example.Project.entity.Payment;
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
    public Payment processPayment(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {
        return paymentService.getPaymentDetails(id);
    }

    @GetMapping("/search")
    public List<Payment> searchPayments(@RequestParam String status) {
        return paymentService.getPaymentsByStatus(status);
    }
}

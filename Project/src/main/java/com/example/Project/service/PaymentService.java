package com.example.Project.service;

import com.example.Project.dto.PaymentRequestDto;
import com.example.Project.dto.PaymentResponseDto;
import com.example.Project.entity.Payment;
import com.example.Project.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponseDto processPayment(PaymentRequestDto request) {
        // Map DTO to Entity
        Payment payment = new Payment();
        payment.setAmount(request.getAmount());
        payment.setStatus("PROCESSED");

        Payment savedPayment = paymentRepository.save(payment);
        return mapToResponseDto(savedPayment);
    }

    public PaymentResponseDto getPaymentDetails(Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment == null) return null;
        return mapToResponseDto(payment);
    }

    public List<PaymentResponseDto> getPaymentsByStatus(String status) {
        List<Payment> payments = paymentRepository.findByStatus(status);
        return payments.stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // Helper method to map Entity to Response DTO
    private PaymentResponseDto mapToResponseDto(Payment payment) {
        PaymentResponseDto responseDto = new PaymentResponseDto();
        responseDto.setId(payment.getId());
        responseDto.setAmount(payment.getAmount());
        responseDto.setStatus(payment.getStatus());
        return responseDto;
    }
}

package com.example.shop.controller;

import com.example.shop.ManagementService;
import com.example.shop.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private ManagementService managementService;

    @GetMapping
    public List<Payment> getPayments() {
        return managementService.getPayments();
    }

    @PostMapping
    public Payment addPayment(@RequestBody Payment payment) {
        return managementService.addPayment(payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        managementService.deletePayment(id);
    }
}

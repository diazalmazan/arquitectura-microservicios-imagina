package com.example.payments_service.service;

import com.example.payments_service.model.Payment;
import com.example.payments_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    public Payment addPayment(Payment payment) {
        var amount = priceWithDiscount(payment.getAmount(), payment.getDiscount());
        payment.setAmount(amount);
        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        var payment = paymentRepository.findById(id);
        paymentRepository.delete(payment.get());
    }

    private double priceWithDiscount(double amount, String discount) {
        if(discount.equals("BLACK_FRIDAY")) {
            return amount * 0.9;
        } else if(discount.equals("CHRISTMAS")) {
            return amount * 0.7;
        } else {
            return amount;
        }
    }
}

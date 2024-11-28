package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.Payment;
import edu.ucalgary.ensf480.group18.user.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServImpl {
    @Autowired
    private PaymentRepo paymentRepo;

    public void deletePayment(Long paymentId) {
        paymentRepo.deleteById(paymentId);
    }

    public void updatePayment(Long paymentId, Payment payment) {
        paymentRepo.save(payment);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public Payment getPaymentById(Long paymentId) {
        return paymentRepo.findById(paymentId).orElse(null);
    }





}

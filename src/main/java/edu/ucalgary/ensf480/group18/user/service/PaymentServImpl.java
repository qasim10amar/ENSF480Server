package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.Payment;
import edu.ucalgary.ensf480.group18.user.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServImpl implements PaymentServ {
    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepo.findById(paymentId).orElse(null);
    }

    @Override
    public void deletePayment(Payment payment) {
        paymentRepo.delete(payment);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    // TODO: Implement refundPayment
    @Override
    public Payment refundPayment(Payment payment) {
        if(payment.getPaid()) {
            payment.setPaid(false);
            int refundAmount = payment.getTicket().getTicketPrice();
        }
        return null;
    }





}

package edu.ucalgary.ensf480.group18.user.repository;

import edu.ucalgary.ensf480.group18.user.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

    @Query("SELECT p FROM Payment p WHERE p.ticket.user.usrEmail = :userEmail")
    List<Payment> findPaymentsByUserEmail(String userEmail);
}

package edu.ucalgary.ensf480.group18.user.repository;

import edu.ucalgary.ensf480.group18.user.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
    @Query("SELECT t FROM Ticket t WHERE t.user.usrEmail = ?1")
    List<Ticket> findTicketsByEmail(String emailAddress);
}

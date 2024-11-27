package edu.ucalgary.ensf480.group18.user.repository;

import edu.ucalgary.ensf480.group18.user.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
}

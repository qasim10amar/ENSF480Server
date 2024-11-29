package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.Ticket;
import edu.ucalgary.ensf480.group18.user.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServImpl implements TicketServ {

        @Autowired
        private TicketRepo ticketRepo;

        @Override
        public Ticket createTicket(Ticket ticket) {
            return ticketRepo.save(ticket);
        }

        @Override
        public Ticket getTicket(Long ticketId) {
            return ticketRepo.findById(ticketId).orElse(null);
        }

        @Override
        public List<Ticket> getTicketByEmailAddress(String emailAddress) {
            return ticketRepo.findTicketsByEmail(emailAddress);
        }

        @Override
        public Ticket emailTicket(Ticket ticket) {
            //Email the ticket to the user
            return ticket;
        }

        @Override
        public Ticket updateTicket(Ticket ticket) {
            return ticketRepo.save(ticket);
        }

        @Override
        public void deleteTicket(Ticket ticket) {
            ticketRepo.delete(ticket);
        }
}

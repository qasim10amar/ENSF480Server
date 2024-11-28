package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.Ticket;

import java.util.List;

public interface TicketServ {
    Ticket createTicket(Ticket ticket);
    Ticket getTicket(Long ticketId);
    List<Ticket> getTicketByEmailAddress(String emailAddress);
}

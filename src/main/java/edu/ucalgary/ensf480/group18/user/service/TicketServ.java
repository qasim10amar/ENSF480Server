package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.Ticket;

public interface TicketServ {
    Ticket createTicket(Ticket ticket);
    Ticket getTicket(Long ticketId);
}

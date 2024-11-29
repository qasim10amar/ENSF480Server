package edu.ucalgary.ensf480.group18.user.controller;

import edu.ucalgary.ensf480.group18.user.model.*;
import edu.ucalgary.ensf480.group18.user.service.CardServ;
import edu.ucalgary.ensf480.group18.user.service.PaymentServ;
import edu.ucalgary.ensf480.group18.user.service.TicketServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentServ paymentService;

    @Autowired
    private CardServ cardService;

    @Autowired
    private TicketServ ticketService;

    @PostMapping("/create")
    public Payment createPayment(@RequestParam String ticketId, @RequestParam String cardNum){
        try{
            if (ticketId == null || cardNum == null)
                throw new IllegalArgumentException("Ticket and card must be provided");

            Card card = cardService.getCard(cardNum);
            Ticket ticket = ticketService.getTicket(Long.parseLong(ticketId));
            if (card == null)
                throw new IllegalArgumentException("Card not found");
            if (ticket == null)
                throw new IllegalArgumentException("Ticket not found");

            Payment payment = paymentService.createPayment(new Payment(ticket, card));
            ticket.setPurchased(true);
            ticketService.updateTicket(ticket);
            //Email the ticket to the user
            ticketService.emailTicket(ticket);

            return payment;
        }
        catch (Exception e){
            return null;
        }

    }

    @PostMapping("/ticket/cancel")
    public void cancelPayment(@RequestParam Long ticketId){
        Ticket ticket = ticketService.getTicket(ticketId);
        if (ticket == null)
            throw new IllegalArgumentException("Ticket not found");
        Seat seat = ticket.getSeat();
        seat.setIsReserved(false);
        ticketService.deleteTicket(ticket);
    }

    @PostMapping("/{paymentId}/refund")
    public void refundPayment(@PathVariable Long paymentId){
        Payment payment = paymentService.getPaymentById(paymentId);
        if (payment == null)
            throw new IllegalArgumentException("Payment not found");

        paymentService.refundPayment(payment);
    }


}

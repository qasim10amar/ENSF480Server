package edu.ucalgary.ensf480.group18.user.controller;

import edu.ucalgary.ensf480.group18.user.model.*;
import edu.ucalgary.ensf480.group18.user.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentServ paymentService;

    @Autowired
    private CardServ cardService;

    @Autowired
    private TicketServ ticketService;

    @Autowired
    private EmailNotificationServ emailNotificationService;

    @Autowired
    private MembershipServ membershipService;

    @PostMapping("/create")
    public Payment createPayment(@RequestParam UUID ticketId, @RequestBody Card card){
        try{
            if (ticketId == null || card == null)
                throw new IllegalArgumentException("Ticket and card must be provided");


            Ticket ticket = ticketService.getTicket(ticketId);
            if (card == null)
                throw new IllegalArgumentException("Card not found");
            if (ticket == null)
                throw new IllegalArgumentException("Ticket not found");

            card.setUser(ticket.getUser());
            Card alreadyInDBCard = cardService.getCard(card.getCardNum());
            if(alreadyInDBCard == null){
                alreadyInDBCard = cardService.createCard(card);
            }

            Payment payment = paymentService.createPayment(new Payment(ticket, alreadyInDBCard));
            ticket.setPurchased(true);
            ticketService.updateTicket(ticket);
            //Email the ticket to the user
            emailNotificationService.emailTicket(ticket);
            return payment;
        }
        catch (Exception e){
            return null;
        }

    }

    @PostMapping("/ticket/cancel")
    public void cancelTicket(@RequestParam UUID ticketId){
        Ticket ticket = ticketService.getTicket(ticketId);
        if (ticket == null)
            throw new IllegalArgumentException("Ticket not found");
        Seat seat = ticket.getSeat();
        seat.setIsReserved(false);
        ticketService.deleteTicket(ticket);
    }

    @PostMapping("/{paymentId}/refund")
    public GiftCard refundPayment(@PathVariable Long paymentId){
        Payment payment = paymentService.getPaymentById(paymentId);
        if (payment == null)
            throw new IllegalArgumentException("Payment not found");

        if(payment.getRefunded())
            throw new IllegalArgumentException("Payment has already been refunded");
        LocalDateTime showTime = payment.getTicket().getSeat().getShowTime().getShowTime();
        //Only refund if the show time is more than 24 hours away
        if (LocalDateTime.now().isBefore(showTime.minusDays(3))){
            GiftCard giftCard = paymentService.refundPayment(payment);
            emailNotificationService.emailGiftCard(payment.getCard().getUser().getUsrEmail(), giftCard);
            return giftCard;
        }
        else {
            throw new IllegalArgumentException("Cannot refund payment within 3 days of show time");
        }

    }


    @PostMapping("/membership/renew")
    public String renewMembership(@RequestParam String email, @RequestParam double paymentAmount) {
        try {
            boolean success = membershipService.processMembershipPayment(email, paymentAmount);
            if (success) {
                return "Membership successfully renewed.";
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return "Failed to renew membership.";
    }

    @GetMapping("/membership/status")
    public String checkMembershipStatus(@RequestParam String email) {
        try {
            boolean isActive = membershipService.isMembershipActive(email);
            return isActive ? "Membership is active." : "Membership has expired.";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public String handleException(IllegalArgumentException e){
        return e.getMessage();
    }

}

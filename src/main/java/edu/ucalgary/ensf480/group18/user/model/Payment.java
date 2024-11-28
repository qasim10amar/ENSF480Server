package edu.ucalgary.ensf480.group18.user.model;

import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    @OneToOne
    @JoinColumn(name = "ticketId")
    private Ticket ticket;
    private Boolean isPaid;
    private String cardNumber;

    public Payment() {
    }

    public Payment(Ticket ticket, Boolean isPaid, String cardNumber) {
        this.ticket = ticket;
        this.isPaid = isPaid;
        this.cardNumber = cardNumber;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}

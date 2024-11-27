package edu.ucalgary.ensf480.group18.user.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    @ManyToOne
    @JoinColumn(name = "usrEmail")
    private User user;

    @ManyToOne
    @JoinColumn(name = "seatId")
    private Seat seat;

    private Boolean isPurchased;

    public Ticket(){

    }

    public Ticket(User user, Seat seat, Boolean isPurchased) {
        this.user = user;
        this.seat = seat;
        this.isPurchased = isPurchased;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Boolean getPurchased() {
        return isPurchased;
    }

    public void setPurchased(Boolean purchased) {
        isPurchased = purchased;
    }
}

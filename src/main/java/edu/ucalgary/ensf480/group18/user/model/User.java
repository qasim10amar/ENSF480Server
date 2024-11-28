package edu.ucalgary.ensf480.group18.user.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long userId;


    private String usrEmail;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Card> cards;

    @Transient
    protected RefundStrategy refundStrategy;

    public User() {
    }

    public User(String usrEmail) {
        this.usrEmail = usrEmail;
        this.refundStrategy = new RegularRefundStrategy();
    }

    public User(String usrEmail, RefundStrategy refundStrategy) {
        this.usrEmail = usrEmail;
        this.refundStrategy = refundStrategy;
    }

    public Long getUserId() {
        return userId;
    }


    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public RefundStrategy getRefundStrategy() {
        return refundStrategy;
    }

    public void setRefundStrategy(RefundStrategy refundStrategy) {
        this.refundStrategy = refundStrategy;
    }
//
//    @OneToMany(mappedBy = "user")
//    private Collection<Ticket> ticket;
//
//    public Collection<Ticket> getTicket() {
//        return ticket;
//    }
//
//    public void setTicket(Collection<Ticket> ticket) {
//        this.ticket = ticket;
//    }
}

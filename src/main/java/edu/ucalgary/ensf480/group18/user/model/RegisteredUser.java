package edu.ucalgary.ensf480.group18.user.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/*
Intended modifications:
- add VIP status, in case user no longer pays anual fee.
- add admin status, to determine if user is an admin
- add credit, to store the credit they got as refund.

- remove userId, since email is unique
- remove returnStrategy, use VIP status to determine refund strategy
- remove annualFee, since it is a constant value
- remove address, it's not used

- merge firstName and lastName into one name

 */
@Entity
public class RegisteredUser {

    @Id
    @Column(unique = true, nullable = false)
    private String usrEmail;
    @Column(nullable = false, columnDefinition = "FLOAT DEFAULT 0.0")
    private float credit;
    private String password;

    @OneToOne(mappedBy = "user")
    private Card card;

    public RegisteredUser() {
    }

    public RegisteredUser(String usrEmail, String password) {
//        super(usrEmail, new RURefundStrategy());
        this.usrEmail = usrEmail;
        this.password = password;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

}

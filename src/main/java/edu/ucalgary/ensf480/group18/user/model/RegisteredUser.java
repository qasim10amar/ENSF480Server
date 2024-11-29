package edu.ucalgary.ensf480.group18.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

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
public class RegisteredUser extends User {
    private static double annualFee = 20.00;
    private String firstName;
    private String lastName;
    private String password;
    @ManyToOne
    @JoinColumn(name = "StreetAddress")
    private Address address;

    @OneToOne(mappedBy = "user")
    private Card card;

    public RegisteredUser() {
    }

    public RegisteredUser(String usrEmail, String firstName, String lastName, String password, Address address) {
        super(usrEmail, new RURefundStrategy());
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
    }

    public static double getAnnualFee() {
        return annualFee;
    }

    public static void setAnnualFee(double annualFee) {
        RegisteredUser.annualFee = annualFee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }



}

package edu.ucalgary.ensf480.group18.user.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class RegisteredUser extends User {
    private static double annualFee = 20.00;
    private String firstName;
    private String lastName;
    private String password;
    @ManyToOne
    @JoinColumn(name = "streetAddress")
    private Address address;

    private LocalDate membershipExpiry;

    @OneToOne(mappedBy = "user")
    private Card card;

    public RegisteredUser() {
    }

    public RegisteredUser(String usrEmail, String firstName, String lastName, String password, Address address) {
        super(usrEmail);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.membershipExpiry = LocalDate.now().plusYears(1);
        setRefundStrategy(new RURefundStrategy());
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

    public RefundStrategy getRefundStrategy() {
        if(refundStrategy == null){
            setRefundStrategy(new RURefundStrategy());
        }
        return refundStrategy;
    }

    public void setRefundStrategy(RefundStrategy refundStrategy) {
        this.refundStrategy = refundStrategy;
    }

    public LocalDate getMembershipExpiry() {
        return membershipExpiry;
    }

    public void setMembershipExpiry(LocalDate membershipExpiry) {
        this.membershipExpiry = membershipExpiry;
    }

    public boolean isMembershipActive() {
        return membershipExpiry != null && LocalDate.now().isBefore(membershipExpiry);
    }

    public void renewMembership() {
        if (isMembershipActive()) {
            membershipExpiry = membershipExpiry.plusYears(1); // Extend existing membership
        } else {
            membershipExpiry = LocalDate.now().plusYears(1); // Start new membership
        }
    }

}

package edu.ucalgary.ensf480.group18.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class RegisteredUser extends User {
    private static double annualFee = 20.00;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "StreetAddress")
    private Address address;

    public RegisteredUser() {
    }

    public RegisteredUser(String usrEmail, String firstName, String lastName, String email, String password, Address address) {
        super(usrEmail, new RURefundStrategy());
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}

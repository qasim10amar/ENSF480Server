package edu.ucalgary.ensf480.group18.user.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
public class Card {
    @Id
    private String cardNum;

    private LocalDate expiry;
    private int cvc;

    private String uerEmail;

    public Card(){}

    public String getCardNum() {
        return cardNum;
    }
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
    public LocalDate getExpiry() {
        return expiry;
    }
    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }
    public int getCvc() {
        return cvc;
    }
    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    @Override
    public String toString(){
        return this.cardNum;
    }



}


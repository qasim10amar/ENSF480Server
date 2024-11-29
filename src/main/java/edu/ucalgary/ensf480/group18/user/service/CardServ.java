package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.Card;

public interface CardServ {
    Card createCard(Card card);
    Card getCard(String cardNum);
    Card updateCard(Card card);
    void deleteCard(String cardNum);
}

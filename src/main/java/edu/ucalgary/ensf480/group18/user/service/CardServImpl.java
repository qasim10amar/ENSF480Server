package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.Card;
import edu.ucalgary.ensf480.group18.user.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServImpl implements CardServ{
    @Autowired
    private CardRepo cardRepo;

    @Override
    public Card createCard(Card card) {
        return cardRepo.save(card);
    }

    @Override
    public Card getCard(String cardNum) {
        return cardRepo.findById(cardNum).orElse(null);
    }

    @Override
    public Card updateCard(Card card) {
        return cardRepo.save(card);
    }

    @Override
    public void deleteCard(String cardNum) {
        cardRepo.deleteById(cardNum);
    }
}

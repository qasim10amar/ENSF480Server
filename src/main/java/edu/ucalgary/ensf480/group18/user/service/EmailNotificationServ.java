package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.GiftCard;
import edu.ucalgary.ensf480.group18.user.model.Movie;
import edu.ucalgary.ensf480.group18.user.model.MovieObserver;
import edu.ucalgary.ensf480.group18.user.model.Ticket;

import java.time.LocalDate;

public interface EmailNotificationServ {
    void sendNewMovieEmail(String email, Movie movie) ;
    void emailTicket(Ticket ticket);

    void emailGiftCard(String emailAddress, GiftCard giftCard);
    void sendMembershipRenewalEmail(String email, LocalDate expiryDate);


}

package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmailNotificationServImpl implements EmailNotificationServ, MovieObserver{

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RegisteredUserServImpl registeredUserServ;

    @Override
    public void notifyNewMovie(Movie movie) {
        // Fetch all registered users
        List<RegisteredUser> users = registeredUserServ.getAllRegisteredUsers();

        // Send email to each user
        for (RegisteredUser user : users) {
            sendNewMovieEmail(user.getUsrEmail(), movie);
        }
    }
    @Override
    public void sendNewMovieEmail(String email, Movie movie) {
        if (email != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("New Movie Added: " + movie.getTitle());
            message.setText(buildNewMovieEmailBody(movie));
            mailSender.send(message);
        }
    }

    @Override
    public void emailTicket(Ticket ticket) {
        // Send the ticket via email
        if (ticket != null && ticket.getUser().getUsrEmail() != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(ticket.getUser().getUsrEmail());
            message.setSubject("Your Ticket Details");
            message.setText(buildTicketEmailBody(ticket));
            mailSender.send(message);
        }
    }

    public void emailGiftCard(String email, GiftCard giftCard) {
        // Send the gift card via email
        if (email != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Your Gift Card Details");
            message.setText(buildGiftCardEmailBody(giftCard));
            mailSender.send(message);
        }
    }

    public void sendMembershipRenewalEmail(String email, LocalDate expiryDate) {
        if (email != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Membership Renewal Reminder");
            message.setText("Dear User,\n\n" +
                    "Your membership will expire on " + expiryDate + ".\n" +
                    "Please renew your membership to continue enjoying our services.\n\n" +
                    "Best regards,\nYour Movie Service Team");
            mailSender.send(message);
        }
    }

    private String buildTicketEmailBody(Ticket ticket) {
        return "Ticket Details: \n" +
                "Ticket ID: " + ticket.getTicketId() + "\n" +
                "Movie: " + ticket.getSeat().getShowTime().getMovie().getTitle() + "\n" +
                "Show Time: " + ticket.getSeat().getShowTime().getShowTime() + "\n" +
                "Seat Number: " + ticket.getSeat().getSeatNumber() + "\n" +
                "Price: " + ticket.getTicketPrice() + "\n" +
                "Enjoy the movie!";
    }

    private String buildGiftCardEmailBody(GiftCard giftCard) {
        return "Gift Card Details: \n" +
                "Gift Card Number: " + giftCard.getGiftCardId() + "\n" +
                "Amount: " + giftCard.getBalance() + "\n" +
                "Expiry Date: " + giftCard.getExpiryDate() + "\n" +
                "Enjoy your gift card!";
    }

    private String buildNewMovieEmailBody(Movie movie) {
        return "Dear User,\n\n" +
                "We are excited to announce a new movie in our collection!\n" +
                "Title: " + movie.getTitle() + "\n" +
                "Genre: " + movie.getGenre() + "\n" +
                "Release Date: " + movie.getReleaseDate() + "\n\n" +
                "Check it out now!\n\n" +
                "Best regards,\nYour Movie Service Team";
    }
}

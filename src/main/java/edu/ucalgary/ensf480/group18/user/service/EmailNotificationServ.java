package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.MovieObserver;

public interface EmailNotificationServ {
    void sendEmail(MovieObserver movieObserver);

}

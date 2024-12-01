package edu.ucalgary.ensf480.group18.user.component;

import edu.ucalgary.ensf480.group18.user.service.EmailNotificationServImpl;
import edu.ucalgary.ensf480.group18.user.service.MovieServImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer {
    @Autowired
    private MovieServImpl movieService;

    @Autowired
    private EmailNotificationServImpl emailNotificationService;

    @PostConstruct
    public void init() {
        movieService.registerObserver(emailNotificationService); // Register email notification as observer
    }
}

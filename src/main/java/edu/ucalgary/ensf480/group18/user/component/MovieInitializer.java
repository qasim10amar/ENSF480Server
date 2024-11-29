package edu.ucalgary.ensf480.group18.user.component;

import edu.ucalgary.ensf480.group18.user.controller.MovieController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieInitializer implements CommandLineRunner {
    @Autowired
    private MovieController movieController;

    @Override
    public void run(String... args) throws Exception {
        movieController.createMovie("The Matrix", "Action", "2024-12-01");
//        movieController.createMovie("Inception", "Thriller", "2010-07-16");
//        movieController.createMovie("Avengers: Endgame", "Action", "2019-04-26");
//        movieController.createMovie("Interstellar", "Sci-Fi", "2014-11-07");
//        movieController.createMovie("Titanic", "Romance", "1997-12-19");
    }
}

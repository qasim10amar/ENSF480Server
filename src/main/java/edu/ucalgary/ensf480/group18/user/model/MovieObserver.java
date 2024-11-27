package edu.ucalgary.ensf480.group18.user.model;

import java.time.LocalDate;

public interface MovieObserver {
        void update(String movieName, LocalDate releaseDate);
}

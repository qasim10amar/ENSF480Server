package edu.ucalgary.ensf480.group18.user.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieSubject {
    private List<MovieObserver> observers = new ArrayList<>();

    public void addObserver(MovieObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(MovieObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String movieName, LocalDate releaseDate) {
        for (MovieObserver observer : observers) {
            observer.update(movieName, releaseDate);
        }
    }
}

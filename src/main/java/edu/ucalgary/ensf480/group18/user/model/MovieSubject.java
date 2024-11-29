package edu.ucalgary.ensf480.group18.user.model;

import java.util.Observer;

public interface MovieSubject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Movie movie);
}

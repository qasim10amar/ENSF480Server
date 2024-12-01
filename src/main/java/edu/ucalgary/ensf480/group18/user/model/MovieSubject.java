package edu.ucalgary.ensf480.group18.user.model;

import edu.ucalgary.ensf480.group18.user.model.Movie;
import edu.ucalgary.ensf480.group18.user.model.MovieObserver;

public interface MovieSubject {
    void registerObserver(MovieObserver observer);
    void removeObserver(MovieObserver observer);
    void notifyObservers(Movie movie);
}
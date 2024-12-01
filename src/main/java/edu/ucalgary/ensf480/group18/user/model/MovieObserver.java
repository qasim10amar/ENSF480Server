package edu.ucalgary.ensf480.group18.user.model;

import edu.ucalgary.ensf480.group18.user.model.Movie;

public interface MovieObserver {
        void notifyNewMovie(Movie movie);
}
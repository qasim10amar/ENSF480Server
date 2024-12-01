package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.Movie;
import edu.ucalgary.ensf480.group18.user.model.MovieObserver;
import edu.ucalgary.ensf480.group18.user.model.MovieSubject;
import edu.ucalgary.ensf480.group18.user.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServImpl implements MovieServ, MovieSubject {
    @Autowired
    private MovieRepo movieRepo;

    private final List<MovieObserver> observers = new ArrayList<>();

    @Override
    public Movie createMovie(Movie movie) {
        Movie savedMovie = movieRepo.save(movie);
        notifyObservers(savedMovie); // Notify all observers when a movie is added
        return savedMovie;
    }

    @Override
    public Movie getMovie(int movieId) {
        return movieRepo.findById(movieId).orElse(null);
    }

    @Override
    public List<Movie> getAllMovies(LocalDate currentDate) {
        return movieRepo.findAllMoviesByDate(currentDate);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public List<Movie> searchMovies(String title) {
        return movieRepo.findAllByTitle(title);
    }

    // Observer Pattern methods
    @Override
    public void registerObserver(MovieObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MovieObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Movie movie) {
        for (MovieObserver observer : observers) {
            observer.notifyNewMovie(movie);
        }
    }
}

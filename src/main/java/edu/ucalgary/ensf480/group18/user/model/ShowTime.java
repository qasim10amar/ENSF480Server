package edu.ucalgary.ensf480.group18.user.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movieId", nullable = false)
    private Movie movie;

    @Column(nullable = false)
    private LocalDateTime showTime;

    public ShowTime() {
    }

    public ShowTime(Movie movie, LocalDateTime showTime) {
        this.movie = movie;
        this.showTime = showTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}

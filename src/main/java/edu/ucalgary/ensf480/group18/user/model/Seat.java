package edu.ucalgary.ensf480.group18.user.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatID;
    private int row;
    private int column;
    private Boolean isReserved;

    @ManyToOne
    @JoinColumn(name = "theaterId")
    private Theater theaterId;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

    public Seat() {
    }

    public Seat(int row, int column, Boolean isReserved, Theater theaterId, Movie movie) {
        this.row = row;
        this.column = column;
        this.isReserved = isReserved;
        this.theaterId = theaterId;
        this.movie = movie;
    }
}

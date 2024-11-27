package edu.ucalgary.ensf480.group18.user.model;

import jakarta.persistence.*;


@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatID;
    private int seatRow;
    private int seatColumn;
    @Column(name = "isReserved")
    private Boolean isReserved;

    @ManyToOne
    @JoinColumn(name = "theaterId")
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

    public Seat() {
    }

    public Seat(int row, int column, Boolean isReserved, Theater theater, Movie movie) {
        this.seatRow = row;
        this.seatColumn = column;
        this.isReserved = isReserved;
        this.theater = theater;
        this.movie = movie;
    }

    public Long getSeatID() {
        return seatID;
    }

    public void setSeatID(Long seatID) {
        this.seatID = seatID;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public void setReserved(Boolean reserved) {
        isReserved = reserved;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

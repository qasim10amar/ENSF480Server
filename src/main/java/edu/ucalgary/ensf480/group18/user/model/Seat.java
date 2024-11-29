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
    @JoinColumn(name = "showTimeId")
    private ShowTime showTime;

    public Seat() {
    }

    public Seat(Long seatID, int seatRow, int seatColumn, Boolean isReserved, ShowTime showTime) {
        this.seatID = seatID;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.isReserved = isReserved;
        this.showTime = showTime;
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
}

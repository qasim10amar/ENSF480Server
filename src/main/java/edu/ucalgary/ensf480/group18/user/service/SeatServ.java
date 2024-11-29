package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.Seat;
import edu.ucalgary.ensf480.group18.user.model.ShowTime;

import java.util.List;

public interface SeatServ {
    Seat createSeat(Seat seat);
    Seat getSeat(Long seatId);
    List<Seat> getAllSeats(ShowTime showTime);

    void updateSeat(Seat seat);

    List<Seat> generateSeats(ShowTime showTime);

}

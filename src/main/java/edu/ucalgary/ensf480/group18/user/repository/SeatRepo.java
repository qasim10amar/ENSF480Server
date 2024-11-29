package edu.ucalgary.ensf480.group18.user.repository;

import edu.ucalgary.ensf480.group18.user.model.Seat;
import edu.ucalgary.ensf480.group18.user.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRepo extends JpaRepository<Seat, Long> {

    @Query("SELECT s FROM Seat s WHERE s.showTime = ?1")
    List<Seat> findByShowTime(ShowTime showTime);
}

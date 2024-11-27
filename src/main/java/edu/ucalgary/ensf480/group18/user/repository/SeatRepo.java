package edu.ucalgary.ensf480.group18.user.repository;

import edu.ucalgary.ensf480.group18.user.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat, Long> {
}

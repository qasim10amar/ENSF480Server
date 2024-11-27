package edu.ucalgary.ensf480.group18.user.repository;

import edu.ucalgary.ensf480.group18.user.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTimeRepo extends JpaRepository<ShowTime, Long> {
}

package edu.ucalgary.ensf480.group18.user.repository;

import edu.ucalgary.ensf480.group18.user.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
    //Get all movies for a given date
    @Query("SELECT m FROM Movie m JOIN m.showTimes s WHERE FUNCTION('DATE', s.showTime) = ?1")
    List<Movie> findAllMoviesByDate(LocalDate currentDate);

    @Query("SELECT m FROM Movie m WHERE LOWER(m.title) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Movie> findAllByTitle(String title);

}

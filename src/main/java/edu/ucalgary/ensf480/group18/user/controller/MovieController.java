package edu.ucalgary.ensf480.group18.user.controller;

import edu.ucalgary.ensf480.group18.user.model.Movie;
import edu.ucalgary.ensf480.group18.user.model.Seat;
import edu.ucalgary.ensf480.group18.user.model.ShowTime;
import edu.ucalgary.ensf480.group18.user.model.Ticket;
import edu.ucalgary.ensf480.group18.user.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieServ movieService;

    @Autowired
    private ShowTimeServ showTimeService;

    @Autowired
    private SeatServ seatService;

    @Autowired
    private UserServ userService;

    @Autowired
    private TicketServ ticketService;

    @GetMapping("/getAll/{date}")
    public List<Movie> getAllMovies(@PathVariable String date){
        LocalDate date1 = LocalDate.parse(date);
        return movieService.getAllMovies(date1);
    }

    //Use this to get the seat details for a specific showtime
    @GetMapping("/get/{showTimeId}")
    public ShowTime getShowTime(@PathVariable Long showTimeId){
        return showTimeService.getShowTime(showTimeId);
    }

//    @PostMapping("/{showTimeId}/createTicket")
//    public void createTicket(@PathVariable Long showTimeId, @RequestBody Long seatId){
//        ShowTime showTime = showTimeService.getShowTime(showTimeId);
//        Seat seat = seatService.getSeat(seatId);
//        //Check if the seat is available
//        if(seat.isAvailable()){
//            //Create a ticket
//            ticketService.createTicket(new Ticket(showTime, seat));
//            //Set the seat to unavailable
//            seat.setAvailable(false);
//            seatService.updateSeat(seat);
//        }
//    }

    @PostMapping("/create")
    public void createMovie(@RequestParam String title, @RequestParam String genre, @RequestParam String releaseDate) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setReleaseDate(LocalDate.parse(releaseDate));

        Movie savedMovie = movieService.createMovie(movie);

        // Generate and add showtimes in place
        List<ShowTime> generatedShowTimes = showTimeService.generateShowTimes(savedMovie);
        for (ShowTime showTime : generatedShowTimes) {
            savedMovie.getShowTimes().add(showTime); // Update the existing collection
        }

        movieService.updateMovie(savedMovie);

        // Generate seats for each showtime
        for (ShowTime showTime : savedMovie.getShowTimes()) {
            List<Seat> seats = seatService.generateSeats(showTime);
            showTime.setSeats(seats);
        }

        System.out.println(savedMovie);
    }



}

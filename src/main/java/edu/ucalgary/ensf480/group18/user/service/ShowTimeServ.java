package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.ShowTime;

import edu.ucalgary.ensf480.group18.user.model.Movie;

import java.util.List;

public interface ShowTimeServ {
    ShowTime createShowTime(ShowTime showTime);
    ShowTime getShowTime(Long showTimeId);
    List<ShowTime> generateShowTimes(Movie movie);
}

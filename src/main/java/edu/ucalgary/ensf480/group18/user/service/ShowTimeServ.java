package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.ShowTime;

public interface ShowTimeServ {
    ShowTime createShowTime(ShowTime showTime);
    ShowTime getShowTime(Long showTimeId);
}

package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.Theater;

import java.util.List;

public interface TheaterServ {
    Theater createTheater(Theater theater);
    Theater getTheater(Long theaterId);
}

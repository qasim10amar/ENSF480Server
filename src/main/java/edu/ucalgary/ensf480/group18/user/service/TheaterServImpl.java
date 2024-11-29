package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.Theater;
import edu.ucalgary.ensf480.group18.user.repository.TheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterServImpl implements TheaterServ {

    @Autowired
    private TheaterRepo theaterRepo;

    @Override
    public Theater createTheater(Theater theater) {
        return theaterRepo.save(theater);
    }

    @Override
    public Theater getTheater(Long theaterId) {
        return theaterRepo.findById(theaterId).orElse(null);
    }

}

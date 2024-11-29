package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.ShowTime;
import edu.ucalgary.ensf480.group18.user.repository.ShowTimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowTimeServImpl implements ShowTimeServ {

        @Autowired
        private ShowTimeRepo showTimeRepo;

        @Override
        public ShowTime createShowTime(ShowTime showTime) {
            return showTimeRepo.save(showTime);
        }

        @Override
        public ShowTime getShowTime(Long showTimeId) {
            return showTimeRepo.findById(showTimeId).orElse(null);
        }
}

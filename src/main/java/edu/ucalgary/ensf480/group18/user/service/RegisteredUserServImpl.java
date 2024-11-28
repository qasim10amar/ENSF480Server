package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.RegisteredUser;
import edu.ucalgary.ensf480.group18.user.repository.RegisteredUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredUserServImpl implements RegisteredUserServ {
    // Registered user service implementation
    @Autowired
    private RegisteredUserRepo registeredUserRepo;

    @Override
    public RegisteredUser createUser(RegisteredUser registeredUser) {
        return registeredUserRepo.save(registeredUser);
    }

    @Override
    public RegisteredUser getUserByEmailAddress(String emailAddress) {
        return registeredUserRepo.findByEmailAddress(emailAddress);
    }

    @Override
    public void deleteUser(RegisteredUser registeredUser) {
        registeredUserRepo.delete(registeredUser);
    }

}

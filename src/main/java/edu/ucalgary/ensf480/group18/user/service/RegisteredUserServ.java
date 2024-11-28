package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.RegisteredUser;

public interface RegisteredUserServ {
    RegisteredUser createUser(RegisteredUser user);
    RegisteredUser getUserByEmailAddress(String emailAddress);
    void deleteUser(RegisteredUser user);
}


package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.RegisteredUser;

import java.util.List;

public interface RegisteredUserServ {
    RegisteredUser createUser(RegisteredUser user);
    RegisteredUser getUserByEmailAddress(String emailAddress);

    List<RegisteredUser> getAllRegisteredUsers();
}


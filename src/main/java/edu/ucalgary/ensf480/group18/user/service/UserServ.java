package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.User;

public interface UserServ {
    User getUserByEmailAddress(String emailAddress);
    User createUser(User user);
    void deleteUser(User user);
}

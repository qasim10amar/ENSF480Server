package edu.ucalgary.ensf480.group18.user.service;

import edu.ucalgary.ensf480.group18.user.model.RegisteredUser;
import edu.ucalgary.ensf480.group18.user.repository.RegisteredUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<RegisteredUser> getAllRegisteredUsers() {
        return registeredUserRepo.findAll(); // Fetch all registered users
    }

    public RegisteredUser getRegisteredUserLogin(String usrEmail, String password) {
        // Fetch the user by email
        RegisteredUser user = registeredUserRepo.findByEmailAddress(usrEmail);

        // If user is found
        if (user != null) {
            System.out.println("Retrieved User: " + user.getUsrEmail());
            System.out.println("Input Password: " + password);
            System.out.println("Stored Password: " + user.getPassword());

            // Compare passwords
            if (password.equals(user.getPassword())) {
                System.out.println("Login successful.");
                return user; // Return user if password matches
            } else {
                System.out.println("Passwords do not match.");
            }
        } else {
            System.out.println("User not found with email: " + usrEmail);
        }

        return null; // Return null if login fails
    }




//    @Override
//    public void deleteUser(RegisteredUser registeredUser) {
//        registeredUserRepo.delete(registeredUser);
//    }

}

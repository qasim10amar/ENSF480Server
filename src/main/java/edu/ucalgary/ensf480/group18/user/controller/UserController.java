package edu.ucalgary.ensf480.group18.user.controller;

import edu.ucalgary.ensf480.group18.user.model.RegisteredUser;
import edu.ucalgary.ensf480.group18.user.model.Ticket;
import edu.ucalgary.ensf480.group18.user.model.User;
import edu.ucalgary.ensf480.group18.user.service.*;
import jdk.jfr.Registered;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServ userService;

    @Autowired
    private RegisteredUserServ registeredUserService;

    @Autowired
    private TicketServ ticketService;

    @Autowired
    private AddressServ addressService;

    @Autowired
    private CardServ cardService;

    @GetMapping("/{UsrEmail}")
    public User findUser(@PathVariable String UsrEmail){
        return userService.getUserByEmailAddress(UsrEmail);
    }

    @GetMapping("/registeredUsers/{UsrEmail}")
    public User findRegisteredUser(@PathVariable String UsrEmail){
        return registeredUserService.getUserByEmailAddress(UsrEmail);
    }

    @GetMapping("/registeredUsers/getTickets/{UsrEmail}")
    public List<Ticket> findRegisteredUserTickets(@PathVariable String UsrEmail){
        return ticketService.getTicketByEmailAddress(UsrEmail);
    }

    @GetMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.createUser(user);
    }

//    @GetMapping("/registeredUsers/add")
//    public RegisteredUser addRegisteredUser(@RequestBody RegisteredUser registeredUser){
//        addressService.createAddress(registeredUser.getAddress());
//        cardService.createCard(registeredUser.getCard());
//        addUser(registeredUser);
//        return registeredUserService.createUser(registeredUser);
//    }


}

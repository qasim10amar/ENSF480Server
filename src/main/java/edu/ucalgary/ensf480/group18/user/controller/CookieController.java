package edu.ucalgary.ensf480.group18.user.controller;

import edu.ucalgary.ensf480.group18.user.model.RegisteredUser;
import edu.ucalgary.ensf480.group18.user.service.CookieServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/cookies")
public class CookieController {

    private final CookieServ cookieService;

    @Autowired
    public CookieController(CookieServ cookieService) {
        this.cookieService = cookieService;
    }

    @PostMapping("/add")
    public String addRow(@RequestBody RegisteredUser user) {
        return "Cookie added with token: " + cookieService.addRow(user).getUserToken();
    }

    @GetMapping("/addDate/{token}")
    public LocalDate getAddDate(@PathVariable String token) {
        return cookieService.getAddDate(token);
    }

    @GetMapping("/userEmail/{token}")
    public String getUserEmail(@PathVariable String token) {
        return cookieService.getUserEmail(token);
    }
}

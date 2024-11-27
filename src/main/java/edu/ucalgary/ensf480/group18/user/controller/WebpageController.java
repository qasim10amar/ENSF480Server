package edu.ucalgary.ensf480.group18.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;


// temp class
class Movie {
    private String title;
    private String cover;
    private String actors;
    private String duration;

    public Movie(String title, String cover, String actors, String duration) {
        this.title = title;
        this.cover = cover;
        this.actors = actors;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public String getActors() {
        return actors;
    }

    public String getDuration() {
        return duration;
    }
}

@Controller
public class WebpageController {
    @GetMapping("/")
    public String home(@CookieValue(name = "USER_TOKEN", defaultValue = "none") String userToken, Model model) {
        // Add data to the model to display in the view
        String name = "Bobby";
        Boolean isVIP = true;
        Boolean isLoggedIn;
        String vipMessage = "VIP valid until ...";
        if (userToken.equals("none")) {
            isLoggedIn = false;
        } else {
            // verify token with database
            isLoggedIn = true;
        }
        model.addAttribute("loggedIn", isLoggedIn);
        if (isLoggedIn) {
            model.addAttribute("name", name);
            // get vip status from database
            if (!isVIP) {
                vipMessage = "Upgrade to VIP more benifits!";
            }
        }
        model.addAttribute("VIP_message", vipMessage);
        // Return the name of the HTML file (without the .html extension)
        return "index";
    }

    @GetMapping("/sign-up")
    public String signUp(@CookieValue(name = "USER_TOKEN", defaultValue = "none") String userToken) {
        return "sign-up";
    }
}


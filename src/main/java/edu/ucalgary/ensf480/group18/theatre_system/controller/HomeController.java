package edu.ucalgary.ensf480.group18.theatre_system.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        // Add data to the model to display in the view
        model.addAttribute("message", "Welcome to Spring Boot!");
        // Return the name of the HTML file (without the .html extension)
        return "index";
    }
}

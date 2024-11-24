package edu.ucalgary.ensf480.group18.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String dashboard() {
        return "admin/dashboard"; // Returns the admin dashboard view
    }
}

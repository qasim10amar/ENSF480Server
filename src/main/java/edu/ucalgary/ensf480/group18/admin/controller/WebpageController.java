package edu.ucalgary.ensf480.group18.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class WebpageController {
    @GetMapping("/")
    public String adminDashboard(@CookieValue(name = "USER_TOKEN", defaultValue = "none") String userToken, Model model) {

        return "admin/index";
    }

}

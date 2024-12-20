package edu.ucalgary.ensf480.group18.user.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

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

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return List.of(
                new Movie("Movie 1", "cover1.jpg", "Actor 1, Actor 2", "120 min"),
                new Movie("Movie 2", "cover2.jpg", "Actor 3, Actor 4", "90 min"),
                new Movie("Movie 3", "cover3.jpg", "Actor 5, Actor 6", "110 min"),
                new Movie("Movie 4", "cover4.jpg", "Actor 7, Actor 8", "100 min"),
                new Movie("Movie 5", "cover5.jpg", "Actor 9, Actor 10", "130 min"),
                new Movie("Movie 6", "cover6.jpg", "Actor 11, Actor 12", "140 min"),
                new Movie("Movie 7", "cover7.jpg", "Actor 13, Actor 14", "150 min"),
                new Movie("Movie 8", "cover8.jpg", "Actor 15, Actor 16", "160 min"),
                new Movie("Movie 9", "cover9.jpg", "Actor 17, Actor 18", "170 min"),
                new Movie("Movie 10", "cover10.jpg", "Actor 19, Actor 20", "180 min"),
                new Movie("Movie 11", "cover11.jpg", "Actor 21, Actor 22", "190 min"),
                new Movie("Movie 12", "cover12.jpg", "Actor 23, Actor 24", "200 min"),
                new Movie("Movie 13", "cover13.jpg", "Actor 25, Actor 26", "210 min"),
                new Movie("Movie 14", "cover14.jpg", "Actor 27, Actor 28", "220 min"),
                new Movie("Movie 15", "cover15.jpg", "Actor 29, Actor 30", "230 min"),
                new Movie("Movie 16", "cover16.jpg", "Actor 31, Actor 32", "240 min"),
                new Movie("Movie 17", "cover17.jpg", "Actor 33, Actor 34", "250 min")
        );
    }
    @PostMapping("/sign-up")
    public Map<String, Object> signUp(@RequestBody RequestBodyConstructor.UserAccount userAccount) {
        // check if email exists
        // if exists, return {"status": 1, "message": "Email already exists"}
        // if not, return {"status": 0, "message": "User created"}
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Alice");
        response.put("age", 25);
        response.put("isStudent", true);
        response.put("grades", new int[]{90, 85, 92}); // Nested data
        return response;
    }

    @PostMapping("/sign-in")
    public Map<String, Object> handleSignIn(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        // Replace with actual database verification logic
        if ("user@example.com".equals(email) && "securePassword".equals(password)) {
            // Success response
            Map<String, Object> response = new HashMap<>();
            response.put("success", 0);
            response.put("message", "Login successful");
            return response;
        }

        // Failure response
        Map<String, Object> response = new HashMap<>();
        response.put("success", 1);
        response.put("message", "Invalid email or password");
        return response;
    }
}

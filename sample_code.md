URL parameter
```java
@GetMapping("/")
public String home(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name, Model model) {
    // Add the name parameter to the model
    model.addAttribute("message", "Welcome, " + name + "!");
    return "index"; // Renders the index.html template
}
```

Get Cookie
```java
@GetMapping("/")
public String home(@CookieValue(name = "userToken", defaultValue = "defaultToken") String userToken, Model model) {
    // Add the cookie value to the model
    model.addAttribute("message", "Your token: " + userToken);
    return "index"; // Renders the index.html template
}
```

Render into html
```java
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // Add data to the model
        model.addAttribute("title", "Welcome Page");
        model.addAttribute("message", "Welcome to Spring Boot!");
        return "index"; // Corresponds to src/main/resources/templates/index.html
    }
}
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title th:text="${title}">Default Title</title>
</head>
<body>
    <h1 th:text="${message}">Default Message</h1>
</body>
</html>
```
Render list/table
```java
@GetMapping("/movies")
public String movies(Model model) {
    List<String> movieList = List.of("Inception", "Interstellar", "The Dark Knight");
    model.addAttribute("movies", movieList);
    return "movies";
}
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movies</title>
</head>
<body>
    <h1>Available Movies</h1>
    <ul>
        <li th:each="movie : ${movies}" th:text="${movie}">Movie Name</li>
    </ul>
</body>
</html>
```
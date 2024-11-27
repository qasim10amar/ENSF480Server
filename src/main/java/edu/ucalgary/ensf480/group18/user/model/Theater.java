package edu.ucalgary.ensf480.group18.user.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterId;

    private String theaterNumber;
    private int capacity;
    private String theaterType;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Movie> movies;







}

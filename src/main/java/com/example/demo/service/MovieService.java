package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Function to add a new Movie entity to the database
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Function to retrieve all Movie entities from the database
    public List<Movie> getPopularMovies() {
        return movieRepository.findAll();
    }
}

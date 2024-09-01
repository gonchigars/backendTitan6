package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setting up mock behavior
        when(movieRepository.findAll()).thenReturn(
            Arrays.asList(
                new Movie("Inception", "2010-07-16"),
                new Movie("Interstellar", "2014-11-07"),
                new Movie("The Dark Knight", "2008-07-18"),
                new Movie("Memento", "2000-10-11")
            )
        );
    }

    @Test
    public void testGetPopularMovies() {
        List<Movie> movies = movieService.getPopularMovies();
        assertNotNull(movies);
        assertEquals(4, movies.size());
        assertTrue(movies.stream().anyMatch(movie -> movie.getTitle().equals("Inception")));
        assertTrue(movies.stream().anyMatch(movie -> movie.getTitle().equals("Interstellar")));
    }
}

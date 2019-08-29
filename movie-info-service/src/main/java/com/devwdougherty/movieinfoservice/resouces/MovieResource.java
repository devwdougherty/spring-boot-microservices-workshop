package com.devwdougherty.movieinfoservice.resouces;

import com.devwdougherty.movieinfoservice.models.Movie;
import com.devwdougherty.movieinfoservice.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {

        Movie persistedMovie = movieRepository.findById(movieId).orElseThrow();

        return persistedMovie;
    }
}

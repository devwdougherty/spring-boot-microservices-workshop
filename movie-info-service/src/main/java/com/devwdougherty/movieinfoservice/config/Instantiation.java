package com.devwdougherty.movieinfoservice.config;

import com.devwdougherty.movieinfoservice.models.Movie;
import com.devwdougherty.movieinfoservice.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
public class Instantiation implements ApplicationRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        movieRepository.deleteAll();

        Movie movie1 = new Movie("123", "Harry Potter");
        Movie movie2 = new Movie("321", "Sing");
        Movie movie3 = new Movie("555", "Piratas do caribe");

        movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3));
    }
}

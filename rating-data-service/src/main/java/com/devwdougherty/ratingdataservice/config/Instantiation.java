package com.devwdougherty.ratingdataservice.config;

import com.devwdougherty.ratingdataservice.models.Rating;
import com.devwdougherty.ratingdataservice.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements ApplicationRunner {

    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        ratingRepository.deleteAll();

        Rating rating1 = new Rating("123", 7);
        Rating rating2 = new Rating("321", 8);
        Rating rating3 = new Rating("555",  9);

        ratingRepository.saveAll(Arrays.asList(rating1, rating2, rating3));
    }
}

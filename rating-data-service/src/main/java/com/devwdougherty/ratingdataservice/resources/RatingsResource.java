package com.devwdougherty.ratingdataservice.resources;

import com.devwdougherty.ratingdataservice.models.Rating;
import com.devwdougherty.ratingdataservice.models.UserRating;
import com.devwdougherty.ratingdataservice.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/ratingsdata")
public class RatingsResource {

    @Autowired
    private RatingRepository ratingRepository;

    @RequestMapping(value = "/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {

        return new Rating(movieId, 4);
    }

    @RequestMapping(value = "users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {

        List<Rating> ratings = ratingRepository.findAll();
        //Iterable<Rating> ratingsIterator = ratingRepository.findAll();

        //ratingsIterator.forEach(list -> ratings.add(list));

        UserRating userRating = new UserRating();
        userRating.setUserRatingList(ratings);

        return userRating;
    }
}

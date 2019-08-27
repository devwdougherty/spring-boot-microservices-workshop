package com.devwdougherty.ratingdataservice.resources;

import com.devwdougherty.ratingdataservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ratingsdata")
public class RatingsResource {

    @RequestMapping(value = "/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {

        return new Rating(movieId, 4);
    }
}

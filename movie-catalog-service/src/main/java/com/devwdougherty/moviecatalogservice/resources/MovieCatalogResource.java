package com.devwdougherty.moviecatalogservice.resources;

import com.devwdougherty.moviecatalogservice.models.CatalogItem;
import com.devwdougherty.moviecatalogservice.models.Movie;
import com.devwdougherty.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogResource {

    /**
     * Default RestTemplate dependency.
     */
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/{userId}")
    public List<CatalogItem> getCatalogItemByUserId(@PathVariable("userId") String userId) {

        /* Get all rated movie IDs */
        List<Rating> ratingList = Arrays.asList(
                new Rating("123", 4),
                new Rating("545", 3),
                new Rating("135", 10)
        );

        /* For each movie ID, call movie info service and get details */
        /* Put them all together */
        return ratingList.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
        })
                .collect(Collectors.toList());
    }
}

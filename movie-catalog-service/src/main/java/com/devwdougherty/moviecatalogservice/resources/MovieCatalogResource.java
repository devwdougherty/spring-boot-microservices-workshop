package com.devwdougherty.moviecatalogservice.resources;

import com.devwdougherty.moviecatalogservice.models.CatalogItem;
import com.devwdougherty.moviecatalogservice.models.Movie;
import com.devwdougherty.moviecatalogservice.models.Rating;
import com.devwdougherty.moviecatalogservice.models.UserRating;
import com.devwdougherty.moviecatalogservice.repositories.CatalogItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
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

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private CatalogItemRepository catalogItemRepository;

    @GetMapping(value = "/{userId}")
    public List<CatalogItem> getCatalogItemByUserId(@PathVariable("userId") String userId) {

        /* Get all rated movie IDs */
        //UserRating ratingList = restTemplate.getForObject("http://localhost:8082/ratingsdata/users/" + userId, UserRating.class);
        UserRating ratingList = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userId, UserRating.class);

        return ratingList.getUserRatingList().stream().map(rating -> {
            /* For each movie ID, call movie info service and get details */
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            /* Put them all together */
            String persistedDesc = catalogItemRepository.findByname(movie.getName()).getDesc();

            return new CatalogItem(movie.getName(), persistedDesc, rating.getRating());
        })
                .collect(Collectors.toList());
    }
}

/*
Alternative WebClient way
Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve().bodyToMono(Movie.class).block();
*/
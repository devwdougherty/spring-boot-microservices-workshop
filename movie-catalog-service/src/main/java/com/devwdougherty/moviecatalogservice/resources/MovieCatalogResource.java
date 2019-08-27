package com.devwdougherty.moviecatalogservice.resources;

import com.devwdougherty.moviecatalogservice.models.CatalogItem;
import com.devwdougherty.moviecatalogservice.models.Rating;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogResource {

    @GetMapping(value = "/{userId}")
    public List<CatalogItem> getCatalogItemByUserId(@PathVariable("userId") String userId) {

        //List<CatalogItem> catalogItemList = new ArrayList<>();

        //catalogItemList.add(new CatalogItem("Transformers", "Robotic Movie", 7));
        //catalogItemList.add(new CatalogItem("HP 7", "Magic Movie", 8));

        /* Get all rated movie IDs */
        List<Rating> ratingList = Arrays.asList(
                new Rating("123", 4),
                new Rating("545", 3),
                new Rating("135", 10)
        );

        return ratingList.stream().map(rating ->
            new CatalogItem("Transformers", "Robotic Movie", 7)
        )
                .collect(Collectors.toList());

        /* For each movie ID, call movie info service and get details */

        /* Put them all together */
        // return catalogItemList;
    }
}

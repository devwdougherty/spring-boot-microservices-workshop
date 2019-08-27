package com.devwdougherty.moviecatalogservice.resources;

import com.devwdougherty.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogResource {

    @GetMapping(value = "/{userId}")
    public List<CatalogItem> getCatalogItemByUserId(@PathVariable("userId") String userId) {

        List<CatalogItem> catalogItemList = new ArrayList<>();

        catalogItemList.add(new CatalogItem("Transformers", "Robotic Movie", 7));
        catalogItemList.add(new CatalogItem("HP 7", "Magic Movie", 8));

        return catalogItemList;
    }
}

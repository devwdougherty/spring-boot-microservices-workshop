package com.devwdougherty.moviecatalogservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogResource {

    @GetMapping
    public String returnStringTest() {
        return "oi spring boot!";
    }
}

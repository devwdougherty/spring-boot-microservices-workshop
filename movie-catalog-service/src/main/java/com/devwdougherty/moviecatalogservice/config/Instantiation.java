package com.devwdougherty.moviecatalogservice.config;

import com.devwdougherty.moviecatalogservice.models.CatalogItem;
import com.devwdougherty.moviecatalogservice.repositories.CatalogItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements ApplicationRunner {

    @Autowired
    private CatalogItemRepository catalogItemRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        catalogItemRepository.deleteAll();

        CatalogItem catalogItem1 = new CatalogItem("Harry Potter", "A magic movie.", 0);
        CatalogItem catalogItem2 = new CatalogItem("Sing", "A sing movie.", 0);
        CatalogItem catalogItem3 = new CatalogItem("Piratas do caribe", "A pirate movie.", 0);

        catalogItemRepository.saveAll(Arrays.asList(catalogItem1, catalogItem2, catalogItem3));
    }
}

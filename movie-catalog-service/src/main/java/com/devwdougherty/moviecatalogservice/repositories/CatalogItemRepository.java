package com.devwdougherty.moviecatalogservice.repositories;

import com.devwdougherty.moviecatalogservice.models.CatalogItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogItemRepository extends CrudRepository<CatalogItem, Long> {

    public CatalogItem findByname(String name);
}

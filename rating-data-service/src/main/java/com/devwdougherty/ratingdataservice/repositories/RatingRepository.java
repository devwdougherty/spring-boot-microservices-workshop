package com.devwdougherty.ratingdataservice.repositories;

import com.devwdougherty.ratingdataservice.models.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

    @Override
    List<Rating> findAll();
}

package com.devwdougherty.movieinfoservice.repositories;

import com.devwdougherty.movieinfoservice.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {
}

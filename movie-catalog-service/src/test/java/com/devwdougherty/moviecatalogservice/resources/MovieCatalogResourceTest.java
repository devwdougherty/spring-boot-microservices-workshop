package com.devwdougherty.moviecatalogservice.resources;

import com.devwdougherty.moviecatalogservice.models.CatalogItem;
import com.devwdougherty.moviecatalogservice.models.Rating;
import com.devwdougherty.moviecatalogservice.models.UserRating;
import com.devwdougherty.moviecatalogservice.repositories.CatalogItemRepository;
import org.hibernate.mapping.Any;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieCatalogResourceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private CatalogItemRepository catalogItemRepository;

    @InjectMocks
    private MovieCatalogResource movieCatalogResource;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getCatalogItemByUserId() {

        Rating rating1 = new Rating("123", 7);
        Rating rating2 = new Rating("321", 8);
        Rating rating3 = new Rating("555",  9);

        UserRating userRating = new UserRating();

        userRating.setUserRatingList(Arrays.asList(rating1, rating2, rating3));

        RestTemplate restTemplate1 = mock(RestTemplate.class);

        when(restTemplate1.getForObject(any(String.class), UserRating.class)).thenReturn(userRating);

        List<CatalogItem>  catalogItemList = movieCatalogResource.getCatalogItemByUserId("1");
    }
}
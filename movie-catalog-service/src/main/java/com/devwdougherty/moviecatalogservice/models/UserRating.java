package com.devwdougherty.moviecatalogservice.models;

import java.util.List;

public class UserRating {

    private List<Rating> userRatingList;

    public List<Rating> getUserRatingList() {
        return userRatingList;
    }

    public void setUserRatingList(List<Rating> userRatingList) {
        this.userRatingList = userRatingList;
    }
}

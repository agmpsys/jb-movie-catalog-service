package com.lanoqo.moviecatalogservice.models;

import java.util.List;

public class UserRating {

    private List<Rating> ratingLst;

    public UserRating() {
    }

    public List<Rating> getRatingLst() {
        return ratingLst;
    }

    public void setRatingLst(List<Rating> ratingLst) {
        this.ratingLst = ratingLst;
    }
}

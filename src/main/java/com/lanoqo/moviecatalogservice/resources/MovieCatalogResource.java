package com.lanoqo.moviecatalogservice.resources;

import com.lanoqo.moviecatalogservice.models.CatalogItem;
import com.lanoqo.moviecatalogservice.models.Movie;
import com.lanoqo.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        //WebClient.Builder

        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 3),
                new Rating("5678", 4)
        );

        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "desc", rating.getRating());
        })
                .collect(Collectors.toList());
    }
}

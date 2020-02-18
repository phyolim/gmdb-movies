package com.galvanize.gmdbmovies.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity(name = "movies")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    @NotEmpty(message = "Imdb Id field may not be empty")
    private String imdbId;
    @NotEmpty(message = "Actors field may not be empty")
    private String actors;
    @NotEmpty(message = "Director field may not be empty")
    private String director;
    @NotEmpty(message = "Title field may not be empty")
    private String title;
    private String year;
    private Date released;
    private String country;
    private String awards;

    public Movie() {
        // default constructor
    }

}

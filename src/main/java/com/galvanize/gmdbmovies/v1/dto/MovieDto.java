package com.galvanize.gmdbmovies.v1.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Required;

import java.util.Date;

@Data
public class MovieDto {
    private Long movieId;
    private String imdbId;
    private String actors;
    private String director;
    private String title;
    private String year;
    private Date released;
    private String country;
    private String awards;

    public MovieDto() {
    }

    public MovieDto(long l, String imdbId, String actors, String director, String title, String year, Date releaseDate) {
    }

    public MovieDto(String title, String country) {
        this.title = title;
        this.country = country;
    }

}

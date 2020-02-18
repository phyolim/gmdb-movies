package com.galvanize.gmdbmovies.v2.dto;

import lombok.Data;

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
}

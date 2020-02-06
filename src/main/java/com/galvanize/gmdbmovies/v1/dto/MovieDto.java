package com.galvanize.gmdbmovies.v1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MovieDto {
    private Long movieId;
    private String imdbid;
    private String actors;
    private String director;
    private String title;
    private String year;
    private Date released;
}
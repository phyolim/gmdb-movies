package com.galvanize.gmdbmovies.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "movies")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String imdbid;
    private String actors;
    private String director;
    private String title;
    private String year;
    private Date released;

    public Movie(long l, String abcd, String joe, String jack, String hello, String s, Date date) {
        this.movieId=l;
    }
}

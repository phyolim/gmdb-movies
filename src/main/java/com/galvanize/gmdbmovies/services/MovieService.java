package com.galvanize.gmdbmovies.services;

import com.galvanize.gmdbmovies.models.Movie;
import com.galvanize.gmdbmovies.repositories.MovieJpaRepository;
import com.galvanize.gmdbmovies.v1.controllers.MovieController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieJpaRepository movieJpaRepository;
    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    public MovieService(MovieJpaRepository movieJpaRepository) {
        this.movieJpaRepository = movieJpaRepository;
    }

    public List<Movie> findAll() {
        return movieJpaRepository.findAll();
    }

    public void createNewMovie(Movie movie) {
        movieJpaRepository.save(movie);
    }

    public Optional<Movie> findByMovieId(Long id) {
        return movieJpaRepository.findById(id);
    }

}

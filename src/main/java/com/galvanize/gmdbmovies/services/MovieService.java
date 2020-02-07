package com.galvanize.gmdbmovies.services;

import com.galvanize.gmdbmovies.models.Movie;
import com.galvanize.gmdbmovies.repositories.MovieJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieJpaRepository movieJpaRepository;

    public MovieService(MovieJpaRepository movieJpaRepository) {
        this.movieJpaRepository = movieJpaRepository;
    }

    public List<Movie> findAll() {
        return movieJpaRepository.findAll();
    }

    public Optional<Movie> findByMovieId(Long id) {
        return movieJpaRepository.findById(id);
    }
}

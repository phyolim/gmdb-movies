package com.galvanize.gmdbmovies.v1.controllers;

import com.galvanize.gmdbmovies.models.Movie;
import com.galvanize.gmdbmovies.services.MovieService;
import com.galvanize.gmdbmovies.v1.dto.MovieDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@Api(tags = "movies controller")
@CrossOrigin(origins = "*")
@RestController("MovieControllerV1")
@RequestMapping(value = "/v1/movies")

public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    final
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @ApiOperation(value = "Retrieves all movies in db")
    @ApiResponses(value = {
            @ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return new ResponseEntity<>(movieService.findAll().stream().map(this::convertToDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    public void createNewMovie(@RequestBody MovieDto movie) {
        movieService.createNewMovie(convertToEntity(movie));
    }

    @GetMapping("/{movieId}")
    public MovieDto getMovieById(@PathVariable Long movieId) {
        return convertToDto(movieService.findByMovieId(movieId).orElse(new Movie()));
    }

    private MovieDto convertToDto(Movie movie) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(movie, MovieDto.class);
    }

    private Movie convertToEntity(MovieDto movieDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(movieDto, Movie.class);
    }
}

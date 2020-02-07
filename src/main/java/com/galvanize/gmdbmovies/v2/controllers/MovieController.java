package com.galvanize.gmdbmovies.v2.controllers;

import com.galvanize.gmdbmovies.models.Movie;
import com.galvanize.gmdbmovies.services.MovieService;
import com.galvanize.gmdbmovies.v2.dto.MovieDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@Api(tags = "movies controller")
@RestController("MovieControllerV2")
@RequestMapping("/v2/movies")
public class MovieController {

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
    public List<MovieDto> getAllMovies() {
        return movieService.findAll().stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{movieId}")
    public Optional<Movie> getMovieById(@PathVariable Long movieId){
        return movieService.findByMovieId(movieId);
    }

    private MovieDto convertToDto(Movie movie) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(movie, MovieDto.class);
    }
}

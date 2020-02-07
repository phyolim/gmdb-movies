package com.galvanize.gmdbmovies.v1.controllers;

import com.galvanize.gmdbmovies.models.Movie;
import com.galvanize.gmdbmovies.services.MovieService;
import com.galvanize.gmdbmovies.v1.dto.MovieDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@Api(tags = "movies controller")
@RestController
public class MovieController {

    final
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/v1/movies")
    @ApiOperation(value = "Retrieves all movies in db")
    @ApiResponses(value = {
            @ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    public List<MovieDto> getAllMovies() {
        return movieService.findAll().stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private MovieDto convertToDto(Movie movie) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(movie, MovieDto.class);
    }
}

package com.galvanize.gmdbmovies.v1.controllers;

import com.galvanize.gmdbmovies.GmdbMoviesApplication;
import com.galvanize.gmdbmovies.models.Movie;
import com.galvanize.gmdbmovies.services.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = {GmdbMoviesApplication.class})
class MovieControllerTest {
    private static MovieController movieController;
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private MovieService movieServiceMock;
    @MockBean
    private Movie movieMock;

    @BeforeEach
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testMoviesEndpointExist() throws Exception {
        String url = "/v1/movies";
        mockMvc
                .perform(get(url))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateNewMovie() throws Exception {
        String url = "v1/movies";
        MockHttpServletRequestBuilder builder = post(url)
                .param("title", "Iron Man")
                .param("country", "USA");
        mockMvc
                .perform(builder)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMovieById() throws Exception {
        String url = "/v1/movies/67";
        mockMvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("67")));
    }


}
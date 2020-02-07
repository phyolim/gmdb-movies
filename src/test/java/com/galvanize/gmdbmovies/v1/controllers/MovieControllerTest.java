package com.galvanize.gmdbmovies.v1.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {
    private static MovieController movieController;
    @Autowired
    MockMvc mvc;

    @Test
    public void testMoviesEndpointExist() throws Exception {
        String url = "/v1/movies";
        mvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMovieById() throws Exception {
        String url = "/v1/movies/67";
        mvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("67")));
    }

}
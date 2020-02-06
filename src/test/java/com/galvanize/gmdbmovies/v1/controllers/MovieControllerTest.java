package com.galvanize.gmdbmovies.v1.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {
    private static MovieController movieController;
    @Autowired
    MockMvc mvc;

    @Test
    public void testMoviesEndpointExist() throws Exception {
        String url = "/movies";
        mvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
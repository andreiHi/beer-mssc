package com.mssc.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mssc.services.BeerService;
import com.mssc.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerJunit5Test {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BeerService beerService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeer() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        given(beerService.saveBeer(any())).willReturn(BeerDto.builder().beerName("New Beer").build());
        final String beerAsJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerAsJson)
        ).andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {
        final BeerDto newBeerDto = BeerDto.builder().beerName("New Beer").build();
        final String beerAsJson = objectMapper.writeValueAsString(newBeerDto);
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerAsJson)
        ).andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteBeer() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/" + UUID.randomUUID()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}

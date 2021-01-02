package com.mssc.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mssc.services.BeerService;
import com.mssc.web.model.BeerDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;

    @Before
    public void setUp() {
        validBeer = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Beer1")
                .beerStyle("Pale_Ale")
                .upc(12345679L)
                .build();
    }

    @Test
    public void whenGetBeerThenReturnBeerById() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);
        mockMvc.perform(get("/api/v1/beer/" + validBeer.getId()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName", is("Beer1")));
    }

    @Test
    public void whenPostBeerThenCreateNewBeer() throws Exception {
        BeerDto saveDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();
        given(beerService.saveBeer(any())).willReturn(saveDto);
        validBeer.setId(null);
        final String beerDtoAsJson = objectMapper.writeValueAsString(validBeer);
        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoAsJson))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void whenPutBeerThenBeerIsUpdated() throws Exception {
        final String beerDtoJson = objectMapper.writeValueAsString(validBeer);
        mockMvc.perform(put("/api/v1/beer/" + validBeer.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .content(beerDtoJson))
                .andDo(print())
                .andExpect(status().isNoContent());
        then(beerService).should().updateBeer(any(), any());
    }

    @Test
    public void whenDeleteBeerByIdThenBeerWasDeleted() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/" + validBeer.getId().toString())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent())
        .andDo(print());
        then(beerService).should().deleteBeer(any());
    }
}

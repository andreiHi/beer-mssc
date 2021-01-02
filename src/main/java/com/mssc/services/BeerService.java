package com.mssc.services;

import com.mssc.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto saveBeer(BeerDto beer);

    void updateBeer(String id, BeerDto beerDto);
}

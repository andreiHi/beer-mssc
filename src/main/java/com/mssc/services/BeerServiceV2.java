package com.mssc.services;

import com.mssc.web.model.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {

    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveBeer(BeerDtoV2 beer);

    void updateBeer(String id, BeerDtoV2 beerDto);

    void deleteBeer(UUID beerId);
}

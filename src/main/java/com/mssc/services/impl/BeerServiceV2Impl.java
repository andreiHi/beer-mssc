package com.mssc.services.impl;

import com.mssc.services.BeerServiceV2;
import com.mssc.web.model.BeerDtoV2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {

    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return null;
    }

    @Override
    public BeerDtoV2 saveBeer(BeerDtoV2 beer) {
        return null;
    }

    @Override
    public void updateBeer(String id, BeerDtoV2 beerDto) {

    }

    @Override
    public void deleteBeer(UUID beerId) {

    }
}

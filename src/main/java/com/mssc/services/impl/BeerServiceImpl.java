package com.mssc.services.impl;

import com.mssc.services.BeerService;
import com.mssc.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxi Cat")
                .beerStyle("Pale Ale")
                .build();

    }

    @Override
    public BeerDto saveBeer(BeerDto beer) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }
}

package com.mssc.services.impl;

import com.mssc.services.BeerService;
import com.mssc.web.model.BeerDto;
import com.mssc.web.model.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxi Cat!!")
                .beerStyle(BeerStyleEnum.ALE)
                .build();

    }

    @Override
    public BeerDto saveBeer(BeerDto beer) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(String id, BeerDto beerDto) {
        // todo
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.info("Beer with id={} was deleted", beerId.toString());
    }

}

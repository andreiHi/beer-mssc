package com.mssc.services.impl;

import com.mssc.domain.Beer;
import com.mssc.services.BeerService;
import com.mssc.web.mapper.BeerMapper;
import com.mssc.web.model.BeerDto;
import com.mssc.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxi Cat!!")
                .beerStyle(BeerStyleEnum.ALE)
                .build();

    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        final Beer beer = beerMapper.beerDtoToBeer(beerDto);
        log.warn("Save beer: {}", beer);
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID id, BeerDto beerDto) {
        final Beer beer = beerMapper.beerDtoToBeer(beerDto);
        log.info("Beer updated {}", beer);
        // todo
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.info("Beer with id={} was deleted", beerId.toString());
    }

}

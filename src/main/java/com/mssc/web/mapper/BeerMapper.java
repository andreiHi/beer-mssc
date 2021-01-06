package com.mssc.web.mapper;

import com.mssc.domain.Beer;
import com.mssc.web.model.BeerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface BeerMapper {

    BeerMapper MAPPER = Mappers.getMapper(BeerMapper.class);

    BeerDto beerToBeerDto(Beer beer);

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "version", ignore = true)
    Beer beerDtoToBeer(BeerDto beerDto);
}

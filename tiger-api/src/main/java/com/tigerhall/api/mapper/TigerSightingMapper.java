package com.tigerhall.api.mapper;

import com.tigerhall.api.graphql.input.TigerInput;
import com.tigerhall.api.graphql.input.TigerSightingInput;
import com.tigerhall.api.model.TigerSighting;
import com.tigerhall.api.rest.dto.CreateTigerDto;
import com.tigerhall.api.rest.dto.TigerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TigerSightingMapper {

    //-- REST API

    TigerDto toTigerDto(TigerSighting tiger);

    TigerSighting toTiger(CreateTigerDto createTigerDto);

    //-- GraphQL

    TigerSighting toTigerSighting(TigerSightingInput tigerSightingInput);
}

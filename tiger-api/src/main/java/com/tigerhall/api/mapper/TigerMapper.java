package com.tigerhall.api.mapper;

import com.tigerhall.api.graphql.input.TigerInput;
import com.tigerhall.api.model.Tiger;
import com.tigerhall.api.rest.dto.CreateTigerDto;
import com.tigerhall.api.rest.dto.TigerDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TigerMapper {

    //-- REST API

    TigerDto toTigerDto(Tiger tiger);

    Tiger toTiger(CreateTigerDto createTigerDto);

    //-- GraphQL

    Tiger toTiger(TigerInput tigerInput);
}

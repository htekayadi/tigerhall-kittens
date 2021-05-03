package com.tigerhall.api.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.tigerhall.api.graphql.input.TigerInput;
import com.tigerhall.api.graphql.service.TigerService;
import com.tigerhall.api.mapper.TigerMapper;
import com.tigerhall.api.model.Tiger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Mutation implements GraphQLMutationResolver {

    private final TigerService tigerService;
    private final TigerMapper tigerMapper;

    // ------
    // Tiger

    public Tiger createTiger(TigerInput tigerInput) {
        Tiger tiger = tigerMapper.toTiger(tigerInput);
        return tigerService.saveTiger(tiger);
    }
}

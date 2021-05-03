package com.tigerhall.api.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tigerhall.api.graphql.service.TigerService;
import com.tigerhall.api.model.Tiger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class Query implements GraphQLQueryResolver {

    private final TigerService tigerService;

    // ------
    // Tiger

    public List<Tiger> getAllTigers() {
        return tigerService.getAllTigers();
    }
}

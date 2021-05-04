package com.tigerhall.api.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tigerhall.api.graphql.service.TigerService;
import com.tigerhall.api.graphql.service.TigerSightingService;
import com.tigerhall.api.model.Tiger;
import com.tigerhall.api.model.TigerSighting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class Query implements GraphQLQueryResolver {

    private final TigerService tigerService;
    private final TigerSightingService tigerSightingService;

    // ------
    // Tiger

    public List<Tiger> getTigers() {
        return tigerService.getTigers();
    }

    // ------
    // TigerSighting

    public List<TigerSighting> getTigerSightings(Long tigerId) {
        return tigerSightingService.getTigerSightings(tigerId);
    }

}

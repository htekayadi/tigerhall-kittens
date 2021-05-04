package com.tigerhall.api.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tigerhall.api.graphql.service.TigerSightingService;
import com.tigerhall.api.model.TigerSighting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TigerSightingResolver implements GraphQLResolver<TigerSighting> {

    private final TigerSightingService tigerSightingService;

    public List<TigerSighting> getTigerSightings(Long tigerId) {
        return tigerSightingService.getTigerSightings(tigerId);
    }

}

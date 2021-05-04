package com.tigerhall.api.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.tigerhall.api.graphql.exception.TigerSightingException;
import com.tigerhall.api.graphql.input.TigerInput;
import com.tigerhall.api.graphql.input.TigerSightingInput;
import com.tigerhall.api.graphql.service.TigerService;
import com.tigerhall.api.graphql.service.TigerSightingService;
import com.tigerhall.api.mapper.TigerMapper;
import com.tigerhall.api.mapper.TigerSightingMapper;
import com.tigerhall.api.model.Tiger;
import com.tigerhall.api.model.TigerSighting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class Mutation implements GraphQLMutationResolver {

    private final Integer NEW_SIGHTING_MININUM_DISTANCE = 5;

    private final TigerService tigerService;
    private final TigerSightingService tigerSightingService;
    private final TigerMapper tigerMapper;
    private final TigerSightingMapper tigerSightingMapper;

    // ------
    // Tiger

    public Tiger createTiger(TigerInput tigerInput) {
        Tiger tiger = tigerMapper.toTiger(tigerInput);
        return tigerService.saveTiger(tiger);
    }

    // ------
    // TigerSighting

    public TigerSighting createTigerSighting(TigerSightingInput tigerSightingInput) {
        Tiger tiger = tigerService.findById(tigerSightingInput.getTigerId());
        validateDistance(tiger.getLastSeenCoordinates(), tigerSightingInput.getCoordinates());

        tiger.setLastSeen(LocalDateTime.parse(tigerSightingInput.getSeen()));
        tiger.setLastSeenCoordinates(tigerSightingInput.getCoordinates());
        tigerService.saveTiger(tiger);

        TigerSighting tigerSighting = tigerSightingMapper.toTigerSighting(tigerSightingInput);
        tigerSighting.setTiger(tiger);
        return tigerSightingService.saveTigerSighting(tigerSighting);
    }

    private void validateDistance(String lastSeenCoordinates, String coordinates) {
        String[] lastSeen = lastSeenCoordinates.split("/");
        String[] seen = coordinates.split("/");
        double x1 = Double.valueOf(lastSeen[0]);
        double y1 = Double.valueOf(lastSeen[1]);
        double x2 = Double.valueOf(seen[0]);
        double y2 = Double.valueOf(seen[1]);

        double dis = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

        if (dis < NEW_SIGHTING_MININUM_DISTANCE) {
            throw new TigerSightingException(String.format("Tiger sighting is within %d kilometers of previous sighting.", NEW_SIGHTING_MININUM_DISTANCE));
        }
    }
}

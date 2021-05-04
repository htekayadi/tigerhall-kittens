package com.tigerhall.api.graphql.service;

import com.tigerhall.api.model.Tiger;
import com.tigerhall.api.model.TigerSighting;
import com.tigerhall.api.repository.TigerSightingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("GraphQLTigerSightingServiceImpl")
public class TigerSightingServiceImpl implements TigerSightingService {

    private final TigerService tigerService;

    private final TigerSightingRepository tigerSightingRepository;

    @Override
    public List<TigerSighting> getAllTigerSightings() {
        return tigerSightingRepository.findAllByOrderBySeenDesc();
    }

    @Override
    public TigerSighting saveTigerSighting(TigerSighting tigerSighting) {

        return tigerSightingRepository.save(tigerSighting);
    }
}

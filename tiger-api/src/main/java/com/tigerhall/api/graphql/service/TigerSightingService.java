package com.tigerhall.api.graphql.service;

import com.tigerhall.api.model.TigerSighting;

import java.util.List;

public interface TigerSightingService {

    List<TigerSighting> getTigerSightings(Long tigerId);

    TigerSighting saveTigerSighting(TigerSighting tigerSighting);

}

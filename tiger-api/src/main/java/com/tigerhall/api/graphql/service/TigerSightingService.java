package com.tigerhall.api.graphql.service;

import com.tigerhall.api.model.TigerSighting;

import java.util.List;

public interface TigerSightingService {

    List<TigerSighting> getAllTigerSightings();

    TigerSighting saveTigerSighting(TigerSighting tigerSighting);

}

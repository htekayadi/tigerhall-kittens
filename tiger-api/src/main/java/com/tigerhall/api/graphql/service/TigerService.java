package com.tigerhall.api.graphql.service;

import com.tigerhall.api.model.Tiger;

import java.util.List;

public interface TigerService {

    List<Tiger> getTigers();

    Tiger findById(Long id);

    Tiger saveTiger(Tiger tiger);

}

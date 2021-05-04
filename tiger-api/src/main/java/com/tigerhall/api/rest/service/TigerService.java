package com.tigerhall.api.rest.service;

import com.tigerhall.api.model.Tiger;

import java.util.List;

public interface TigerService {

    List<Tiger> getTigers();

    Tiger validateAndGetAuthorById(Long id);

    Tiger validateAndGetAuthorByName(String name);

    Tiger saveAuthor(Tiger tiger);

    void deleteAuthor(Tiger tiger);

}

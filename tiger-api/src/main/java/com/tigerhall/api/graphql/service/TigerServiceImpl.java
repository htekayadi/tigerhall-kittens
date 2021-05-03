package com.tigerhall.api.graphql.service;

import com.tigerhall.api.model.Tiger;
import com.tigerhall.api.repository.TigerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("GraphQLAuthorServiceImpl")
public class TigerServiceImpl implements TigerService {

    private final TigerRepository tigerRepository;

    @Override
    public List<Tiger> getAllTigers() {
        return tigerRepository.findAll();
    }

    @Override
    public Tiger saveTiger(Tiger tiger) {
        return tigerRepository.save(tiger);
    }
}

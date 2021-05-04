package com.tigerhall.api.graphql.service;

import com.tigerhall.api.model.Tiger;
import com.tigerhall.api.repository.TigerRepository;
import com.tigerhall.api.rest.exception.TigerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("GraphQLTigerServiceImpl")
public class TigerServiceImpl implements TigerService {

    private final TigerRepository tigerRepository;

    @Override
    public List<Tiger> getTigers() {
        return tigerRepository.findAllByOrderByLastSeenDesc();
    }

    @Override
    public Tiger findById(Long id) {
        return tigerRepository.findById(id).orElseThrow(() -> new TigerNotFoundException(String.format("Tiger with id '%d' not found", id)));
    }

    @Override
    public Tiger saveTiger(Tiger tiger) {
        return tigerRepository.save(tiger);
    }
}

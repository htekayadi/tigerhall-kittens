package com.tigerhall.api.rest.service;

import com.tigerhall.api.model.Tiger;
import com.tigerhall.api.repository.TigerRepository;
import com.tigerhall.api.rest.exception.TigerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("RestAuthorServiceImpl")
public class TigerServiceImpl implements TigerService {

    private final TigerRepository tigerRepository;

    @Override
    public List<Tiger> getAllTigers() {
        return tigerRepository.findAll();
    }

    @Override
    public Tiger validateAndGetAuthorById(Long id) {
        return tigerRepository.findById(id).orElseThrow(() -> new TigerNotFoundException(String.format("Author with id '%s' not found", id)));
    }

    @Override
    public Tiger validateAndGetAuthorByName(String name) {
        final String nameNormSpace = StringUtils.normalizeSpace(name);
        return tigerRepository.findByNameIgnoreCase(nameNormSpace)
                .stream()
                .findFirst()
                .orElseThrow(() -> new TigerNotFoundException(String.format("Tiger with name '%s' not found", nameNormSpace)));
    }

    @Override
    public Tiger saveAuthor(Tiger tiger) {
        return tigerRepository.save(tiger);
    }

    @Override
    public void deleteAuthor(Tiger tiger) {
        tigerRepository.delete(tiger);
    }

}

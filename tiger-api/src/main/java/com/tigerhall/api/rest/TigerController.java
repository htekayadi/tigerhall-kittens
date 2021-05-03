package com.tigerhall.api.rest;

import com.tigerhall.api.mapper.TigerMapper;
import com.tigerhall.api.model.Tiger;
import com.tigerhall.api.rest.dto.CreateTigerDto;
import com.tigerhall.api.rest.dto.TigerDto;
import com.tigerhall.api.rest.service.TigerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tigers")
public class TigerController {

    private final TigerService tigerService;
    private final TigerMapper tigerMapper;

    @GetMapping
    public List<TigerDto> getAllTigers() {
        return tigerService.getAllTigers()
                .stream()
                .map(tigerMapper::toTigerDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/name/{tigerName}")
    public TigerDto getAuthorByName(@PathVariable String tigerName) {
        Tiger tiger = tigerService.validateAndGetAuthorByName(tigerName);
        return tigerMapper.toTigerDto(tiger);
    }

    @GetMapping("/{tigerId}")
    public TigerDto getAuthorById(@PathVariable Long tigerId) {
        Tiger tiger = tigerService.validateAndGetAuthorById(tigerId);
        return tigerMapper.toTigerDto(tiger);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TigerDto createAuthor(@Valid @RequestBody CreateTigerDto createTigerDto) {
        Tiger tiger = tigerMapper.toTiger(createTigerDto);
        tiger = tigerService.saveAuthor(tiger);
        return tigerMapper.toTigerDto(tiger);
    }

    @DeleteMapping("/{tigerId}")
    public TigerDto deleteAuthor(@PathVariable Long tigerId) {
        Tiger tiger = tigerService.validateAndGetAuthorById(tigerId);
        tigerService.deleteAuthor(tiger);
        return tigerMapper.toTigerDto(tiger);
    }
}

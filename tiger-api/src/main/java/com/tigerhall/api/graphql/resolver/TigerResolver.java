package com.tigerhall.api.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tigerhall.api.graphql.service.TigerService;
import com.tigerhall.api.model.Tiger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TigerResolver implements GraphQLResolver<Tiger> {

    private final TigerService tigerService;

    public List<Tiger> getAllTigers() {
        return tigerService.getAllTigers();
    }

}

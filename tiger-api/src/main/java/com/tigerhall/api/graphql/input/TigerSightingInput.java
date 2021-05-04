package com.tigerhall.api.graphql.input;

import lombok.Data;

@Data
public class TigerSightingInput {

    private Long tigerId;
    private String seen;
    private String coordinates;
}

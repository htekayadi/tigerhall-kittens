package com.tigerhall.api.graphql.input;

import lombok.Data;

import javax.servlet.http.Part;

@Data
public class TigerSightingInput {

    private Long tigerId;
    private String seen;
    private String coordinates;
    private Part image;
}

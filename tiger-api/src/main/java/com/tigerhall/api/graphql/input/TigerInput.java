package com.tigerhall.api.graphql.input;

import lombok.Data;

@Data
public class TigerInput {

    private String name;
    private String dateOfBirth;
    private String lastSeenAt;
    private String lastSeenCoordinates;
}

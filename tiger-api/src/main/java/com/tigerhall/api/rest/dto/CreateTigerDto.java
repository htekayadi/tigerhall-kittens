package com.tigerhall.api.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateTigerDto {

    @Schema(example = "Kitty Purry")
    @NotBlank
    private String name;

}

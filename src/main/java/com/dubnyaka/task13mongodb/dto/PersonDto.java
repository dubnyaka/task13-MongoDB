package com.dubnyaka.task13mongodb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder
@Jacksonized
public class PersonDto {
    private String id;

    private String full_name;

    private String type_of_official;

    private boolean is_pep;

    private boolean died;
}

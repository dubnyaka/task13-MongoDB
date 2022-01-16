package com.dubnyaka.task13mongodb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder
@Jacksonized
public class PersonSaveDto {
    private String id;

    private String first_name;

    private String last_name;
}

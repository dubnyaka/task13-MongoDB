package com.dubnyaka.task13mongodb.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "pep")
public class PersonData {

    @Id
    private String id;

    private String type_of_official;

    private String first_name;

    private String last_name;

    private List<Object> related_persons;

    private Boolean is_pep;

    private String photo;

    private String full_name_en;

    private String first_name_en;

    private String last_name_en;

    private String url;

    private String date_of_birth;

    private String type_of_official_en;

    private String full_name;

    private String patronymic;

    private String patronymic_en;

    private Boolean died;

    private String also_known_as_en;

    private String names;
}


package com.dubnyaka.task13mongodb.service;

import com.dubnyaka.task13mongodb.dto.PersonDto;

import java.util.List;

public interface PersonService {

    void saveClient(PersonDto clientDto);

    List<PersonDto> getAllClients();

    PersonDto getClient(String id);

    boolean updatePerson(PersonDto personDto);

    boolean deletePerson(String id);
}

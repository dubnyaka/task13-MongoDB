package com.dubnyaka.task13mongodb.service;

import com.dubnyaka.task13mongodb.data.PersonData;
import com.dubnyaka.task13mongodb.dto.PersonDto;

import java.util.List;

public interface PersonService {

    void savePerson(PersonDto clientDto);

    List getAllPersons();

    PersonData getPerson(String id);

    List getPersonByLastname(String lastname);

    boolean updatePerson(PersonDto personDto);

    boolean deletePerson(String id);
}

package com.dubnyaka.task13mongodb.service;

import com.dubnyaka.task13mongodb.data.PersonData;
import com.dubnyaka.task13mongodb.dto.PersonDto;
import com.dubnyaka.task13mongodb.dto.PersonSaveDto;

import java.util.List;

public interface PersonService {

    String savePerson(PersonSaveDto personDto);

    List getAllPersons();

    PersonData getPerson(String id);

    List getPersonByLastname(String lastname);

    boolean updatePerson(PersonDto personDto);

    boolean deletePerson(String id);
}

package com.dubnyaka.task13mongodb.service;

import com.dubnyaka.task13mongodb.dao.PersonDao;
import com.dubnyaka.task13mongodb.data.PersonData;
import com.dubnyaka.task13mongodb.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Override
    public void saveClient(PersonDto clientDto) {

    }

    @Override
    public List<PersonDto> getAllClients() {
        Optional<List<PersonData>> personDataList = personDao.getAll();
        if(personDataList.isPresent()){
            return personDataList.get().stream().map(this::convertDataToDto).toList();
        }
        return null;
    }

    @Override
    public PersonDto getClient(String id) {
        return personDao.get(id)
                .map(this::convertDataToDto)
                .orElse(null);
    }

    @Override
    public boolean updatePerson(PersonDto personDto) {
        return false;
    }

    @Override
    public boolean deletePerson(String id) {
        return false;
    }

    private PersonDto convertDataToDto(PersonData data){
        return PersonDto.builder()
                .id(data.getId())
                .firstName(data.getFirst_name())
                .lastName(data.getLast_name())
                .build();
    }
}

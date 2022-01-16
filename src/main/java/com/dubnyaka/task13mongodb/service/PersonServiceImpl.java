package com.dubnyaka.task13mongodb.service;

import com.dubnyaka.task13mongodb.dao.PersonDao;
import com.dubnyaka.task13mongodb.data.PersonData;
import com.dubnyaka.task13mongodb.dto.PersonDto;
import com.dubnyaka.task13mongodb.dto.PersonSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Override
    public String savePerson(PersonSaveDto personDto) {
        PersonData personData = new PersonData();
        copyDtoToData(personDto,personData);
        personDao.save(personData);
        return personData.getId();
    }

    @Override
    public List<PersonDto> getAllPersons() {
        Optional<List<PersonData>> personDataList = personDao.getAll();
        if (personDataList.isPresent()) {
            return personDataList.get().stream().map(this::convertDataToDto).toList();
        }
        return null;
    }

    public List<Map.Entry<String,Integer>> getTop10PopularNames() {
        LinkedHashMap<String, Integer> output = new LinkedHashMap<>();
        Optional<List<PersonData>> persons = personDao.getAll();
        if (persons.isPresent()) {
            for(PersonData personData: persons.get()){
                if (personData.getIs_pep()) {
                    output.computeIfPresent(personData.getFirst_name(), (key,value) -> value + 1);
                    output.putIfAbsent(personData.getFirst_name(), 1);
                }
            }
        }
        return output.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(10).toList();
    }

    @Override
    public PersonData getPerson(String id) {
        return personDao.get(id).orElse(null);
//                .map(this::convertDataToDto)
//                .orElse(null);
    }

    @Override
    public List<PersonDto> getPersonByLastname(String lastname) {
        return personDao.getByLastname(lastname)
                .stream().map(data -> PersonDto.builder()
                        .id(data.getId())
                        .first_name(data.getFirst_name())
                        .last_name(data.getLast_name())
                        .build()
                ).toList();
    }

    @Override
    public boolean updatePerson(PersonDto personDto) {
        return false;
    }

    @Override
    public boolean deletePerson(String id) {
        return false;
    }

    private void copyDtoToData(PersonSaveDto personDto, PersonData personData){
        personData.setFirst_name(personDto.getFirst_name());
        personData.setLast_name(personDto.getLast_name());
        personData.setId(personDto.getId());
    }

    private PersonDto convertDataToDto(PersonData data) {
        return PersonDto.builder()
                .id(data.getId())
                .first_name(data.getFirst_name())
                .last_name(data.getLast_name())
                .build();
    }
}

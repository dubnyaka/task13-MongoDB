package com.dubnyaka.task13mongodb.service;

import com.dubnyaka.task13mongodb.dao.PersonDao;
import com.dubnyaka.task13mongodb.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public List<Map.Entry<String, Integer>> getTop10PepFirstNames() {
        List<String> pepFirstNames = personDao.getPepOnlyFirstNames()
                .stream().map(document -> document.getString("first_name")).toList();

        LinkedHashMap<String, Integer> output = new LinkedHashMap<>();
        for (String pepFirstName : pepFirstNames) {
            output.computeIfPresent(pepFirstName, (key, value) -> value + 1);
            output.putIfAbsent(pepFirstName, 1);
        }

        return output.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10).toList();
    }

    public List<PersonDto> getPersonByFullName(String fullName){
        return personDao.findByFull_name(fullName);
    }

}

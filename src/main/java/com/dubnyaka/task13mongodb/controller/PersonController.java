package com.dubnyaka.task13mongodb.controller;

import com.dubnyaka.task13mongodb.data.PersonData;
import com.dubnyaka.task13mongodb.dto.PersonDto;
import com.dubnyaka.task13mongodb.service.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/clients")
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl personService;

    @GetMapping("")
    public List<PersonDto> getAll() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public PersonData get(@PathVariable("id") String id) {
        return personService.getPerson(id);
    }

    @GetMapping("/find/{lastname}")
    public List<PersonDto> getByLastname(@PathVariable("lastname") String lastname) {
        return personService.getPersonByLastname(lastname);
    }

    @GetMapping("/top10")
    public List<Map.Entry<String,Integer>> getTop10PopularNames(){
        return personService.getTop10PopularNames();
    }

}


























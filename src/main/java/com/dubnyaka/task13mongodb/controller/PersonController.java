package com.dubnyaka.task13mongodb.controller;

import com.dubnyaka.task13mongodb.data.PersonData;
import com.dubnyaka.task13mongodb.dto.PersonDto;
import com.dubnyaka.task13mongodb.dto.PersonSaveDto;
import com.dubnyaka.task13mongodb.service.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/persons")
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl personService;

    @GetMapping
    public List<PersonDto> getAllPerson() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public PersonData getPerson(@PathVariable("id") String id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody PersonSaveDto personSaveDto){
        String id = personService.savePerson(personSaveDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(id);
    }

    @GetMapping("/find/{lastname}")
    public List<PersonDto> getPersonByLastname(@PathVariable("lastname") String lastname) {
        return personService.getPersonByLastname(lastname);
    }

    @GetMapping("/top10")
    public List<Map.Entry<String,Integer>> getTop10PopularNames(){
        return personService.getTop10PopularNames();
    }

}


























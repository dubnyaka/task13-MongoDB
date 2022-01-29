package com.dubnyaka.task13mongodb.controller;

import com.dubnyaka.task13mongodb.dto.PersonDto;
import com.dubnyaka.task13mongodb.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/persons")
@RestController
@RequiredArgsConstructor
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/top10FirstNames")
    List<Map.Entry<String, Integer>> top10FirstNames() {
        return personService.getTop10PepFirstNames();
    }

    @GetMapping("/find/{fullName}")
    public List<PersonDto> getPersonByFullName(@PathVariable("fullName") String fullName) {
        return personService.getPersonByFullName(fullName);
    }
}


























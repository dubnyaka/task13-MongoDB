package com.dubnyaka.task13mongodb.controller;

import com.dubnyaka.task13mongodb.dto.PersonDto;
import com.dubnyaka.task13mongodb.service.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/clients")
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl personService;

    @GetMapping("")
    public List<PersonDto> getAll() {
        return personService.getAllClients();
    }

    @GetMapping("/{id}")
    public PersonDto get(@PathVariable("id") String id) {
        return personService.getClient(id);
    }

}


























package com.techgeeknext.controller;

import com.techgeeknext.entities.people.People;
import com.techgeeknext.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/traindb")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping(value = "/findAll")
    public List<People> findAll() {
        log.info("Start TrainDB Controller");
        return peopleService.findAll();
    }
}

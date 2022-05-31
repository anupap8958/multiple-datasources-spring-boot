package com.techgeeknext.service;

import com.techgeeknext.entities.people.People;
import com.techgeeknext.repository.people.PeopleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    public List<People> findAll() {
        return peopleRepository.findAll();
    }
}
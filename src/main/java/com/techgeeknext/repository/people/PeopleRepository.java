package com.techgeeknext.repository.people;

import com.techgeeknext.entities.people.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class PeopleRepository{
    @Autowired
    @Qualifier("peopleJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<People> findAll(){
        String sql = "SELECT * FROM people";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(People.class));
    }
}
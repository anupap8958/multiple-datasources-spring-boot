package com.techgeeknext.repository.agtcontract;

import com.techgeeknext.entities.agtcontract.AgtContract;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class AgtContractRepository {
    @Autowired
    @Qualifier("oracleJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<AgtContract> findAll(){
        String sql = "SELECT * FROM AGT_CONTRACT";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AgtContract.class));
    }

}
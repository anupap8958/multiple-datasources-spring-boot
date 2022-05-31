package com.techgeeknext.service;

import com.techgeeknext.entities.agtcontract.AgtContract;
import com.techgeeknext.repository.agtcontract.AgtContractRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class AgtContractService {
    @Autowired
    private AgtContractRepository agtContractRepository;

    @Transactional("peopleTransactionManager")
    public List<AgtContract> findAll() {
        return agtContractRepository.findAll();
    }
}
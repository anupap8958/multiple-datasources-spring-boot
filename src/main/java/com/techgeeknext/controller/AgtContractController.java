package com.techgeeknext.controller;

import com.techgeeknext.entities.agtcontract.AgtContract;
import com.techgeeknext.service.AgtContractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/dslcord")
public class AgtContractController {

    @Autowired
    private AgtContractService agtContractService;

    @GetMapping(value = "/findAll")
    public List<AgtContract> findAll() {
        log.info("Start DSLCORD Controller");
        return agtContractService.findAll();
    }
}

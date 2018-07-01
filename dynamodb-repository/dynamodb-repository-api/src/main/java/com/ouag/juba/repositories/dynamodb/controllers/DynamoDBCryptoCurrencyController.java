package com.ouag.juba.repositories.dynamodb.controllers;


import com.ouag.juba.repositories.dynamodb.DynamoDBCryptoCurrencyRepository;
import com.ouag.juba.repositories.dynamodb.model.DynamoDBCryptoCurrency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.ouag.juba.repositories.dynamodb.controllers.MappingConstants.URL_ROOT;

@RestController
@Slf4j
@RequestMapping(URL_ROOT+"/cryptocurrency")
public class DynamoDBCryptoCurrencyController {

    @Autowired
    DynamoDBCryptoCurrencyRepository repository;

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete() {

        repository.deleteAll();
        return "Done";
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<DynamoDBCryptoCurrency> get() {
       return repository.findAll();
    }


}

package com.ouag.juba.repositories.dynamodb.controllers;


import com.ouag.juba.repositories.dynamodb.DynamoDBCryptoCurrencyRepository;

import com.ouag.juba.repositories.dynamodb.model.DynamoDBCryptoCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;

import static com.ouag.juba.repositories.dynamodb.controllers.MappingConstants.*;

@RestController
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

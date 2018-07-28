package com.ouag.juba.repositories.dynamodb.controllers;


import com.ouag.juba.repositories.dynamodb.DynamoDBCryptoCurrencyRepository;
import com.ouag.juba.repositories.dynamodb.model.DynamoDBCryptoCurrency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.ouag.juba.repositories.dynamodb.controllers.MappingConstants.URL_ROOT;

@RestController
@Slf4j
@RequestMapping(URL_ROOT+"/cryptocurrency")
public class DynamoDBCryptoCurrencyController {

    @Autowired
    DynamoDBCryptoCurrencyRepository repository;

    @DeleteMapping
    public String deleteAll() {
        repository.deleteAll();
        return "Done";
    }

    @GetMapping
    public Iterable<DynamoDBCryptoCurrency> getAll() {
       return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<DynamoDBCryptoCurrency> get(@PathVariable("id") Long id) {
        return repository.findById(String.valueOf(id));
    }


    @PostMapping
    public DynamoDBCryptoCurrency create(DynamoDBCryptoCurrency dynamoDBCryptoCurrency) {
        return repository.save(dynamoDBCryptoCurrency);
    }

    @PutMapping("/{id}")
    public DynamoDBCryptoCurrency update(@PathVariable("id") Long id, DynamoDBCryptoCurrency dynamoDBCryptoCurrency) {
        return repository.save(dynamoDBCryptoCurrency);
    }


}

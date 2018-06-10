package com.ouag.juba.repositories;

import com.ouag.juba.repositories.model.DynamoDBCryptoCurrency;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface DynamoDBCryptoCurrencyRepository extends CrudRepository<DynamoDBCryptoCurrency, String> {

        List<DynamoDBCryptoCurrency> findById(String id);
}

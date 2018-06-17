package com.ouag.juba.repositories.dynamodb;

import com.ouag.juba.repositories.dynamodb.model.DynamoDBCryptoCurrency;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
public interface DynamoDBCryptoCurrencyRepository extends CrudRepository<DynamoDBCryptoCurrency, String> {

}

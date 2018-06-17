package com.ouag.juba.repositories.dynamodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.ouag.juba.repositories.dynamodb")
public class DynamoDBRepositoryApplication {


    public static void main(String[] args) {
        SpringApplication.run(DynamoDBRepositoryApplication.class, args);
    }

}


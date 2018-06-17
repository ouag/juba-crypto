package com.ouag.juba.repositories.dynamodb;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.ouag.juba.repositories.dynamodb.model.DynamoDBCryptoCurrency;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DynamoDBRepositoryApplication.class)
@WebAppConfiguration
@ActiveProfiles("local")
public class DynamoDBCryptoCurrencyRepositoryIT {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    DynamoDBCryptoCurrencyRepository dynamoDBCryptoCurrencyRepository;

    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        CreateTableRequest tableRequest = dynamoDBMapper
                .generateCreateTableRequest(DynamoDBCryptoCurrency.class);
        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);

        dynamoDBMapper.batchDelete(
                (List<DynamoDBCryptoCurrency>) dynamoDBCryptoCurrencyRepository.findAll());
    }

    @Test
    public void sampleTestCase() {
        DynamoDBCryptoCurrency xbt = new DynamoDBCryptoCurrency();
        dynamoDBCryptoCurrencyRepository.save(xbt);

        List<DynamoDBCryptoCurrency> result
                = (List<DynamoDBCryptoCurrency>) dynamoDBCryptoCurrencyRepository.findAll();

        //assertTrue("Not empty", result.size() > 0);
        //assertTrue("Contains item with expected cost",
        //        result.get(0).getCost().equals(EXPECTED_COST));
    }

}

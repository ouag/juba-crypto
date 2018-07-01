* Install localy DynamoDB

https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html#DynamoDBLocal.DownloadingAndRunning

* Location 

$HOME/Library/aws/dev/dynamodb

* launch DynamoDB

java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
# AWS Lambda With DynamoDB Streams

Order Processing Example Using AWS Lambda with DynamoDB streams. 

### Serverless Framework

```yaml

# First make sure your resource includes a StreamSpecifcation so that is setup up the stream
resources:
  Resources:
    MyTable:
      Type: AWS::DynamoDB::Table
      Properties:
        TableName: my_table
        AttributeDefinitions:
          - AttributeName: id
            AttributeType: S
        KeySchema:
          - AttributeName: id
            KeyType: HASH
        ProvisionedThroughput:
          ReadCapacityUnits: 5
          WriteCapacityUnits: 5
        StreamSpecification:
          StreamViewType: NEW_AND_OLD_IMAGES
#  http://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_StreamSpecification.html
          
# You also need to make sure your iamRoleStatement has the correct permissions.          
provider:
  iamRoleStatements:
    - Effect: Allow
      Action:
        - dynamodb:DescribeStream
        - dynamodb:GetRecords
        - dynamodb:GetShardIterator
        - dynamodb:ListStreams
      Resource: arn:aws:dynamodb:*:*:table/my_table

# Finally configure your function with a stream event using the Stream ARN.
 streamFunction:
    handler: streamFunction.handler
    events:
      - stream:
        type: dynamodb
        arn:
          Fn::GetAtt:
          - MyTable
          - StreamArn
        batchSize: 1
      
```


### Key Points of DynamoDb Streams

##### StreamViewType:
When an item in the table is modified, StreamViewType determines
what information is written to the stream for this table. Valid values for StreamViewType are:

- `KEYS_ONLY` - Only the key attributes of the modified item are written to the stream.
- `NEW_IMAGE` - The entire item, as it appears after it was modified, is written to the stream.
- `OLD_IMAGE` - The entire item, as it appeared before it was modified, is written to the stream.
- `NEW_AND_OLD_IMAGES` - Both the new and the old item images of the item are written to the stream.

##### Record
- **eventName** : 
    The type of data modification that was performed on the DynamoDB table:      
    - `INSERT` - a new item was added to the table.      
    - `MODIFY` - one or more of an existing item's attributes were modified.      
    - `REMOVE` - the item was deleted from the table             

package bhuwanupadhyay.dynamodb.streams.data;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import java.util.List;
import java.util.Optional;

import static com.amazonaws.regions.Regions.US_EAST_1;
import static com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder.EndpointConfiguration;
import static com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder.standard;
import static com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.builder;
import static java.lang.String.format;
import static java.util.Optional.ofNullable;

public class OrderRepository {

    private final DynamoDBMapper mapper = new DynamoDBMapper(db(), builder()
            .withTableNameResolver((clazz, config) -> System.getenv("TABLE"))
            .build());

    private AmazonDynamoDB db() {
        return isLocal() ? localDb() : remoteDb();
    }

    private EndpointConfiguration localEndpoint() {
        return new EndpointConfiguration("http://dynamodb:8000", US_EAST_1.getName());
    }

    public void persist(Order order) {
        getByOrderId(order.getOrderId()).ifPresent(c -> {
            throw new DataException(format("Duplicate order [orderId=%s]", order.getOrderId()));
        });
        mapper.save(order);
    }

    public void update(Order order) {
        getByOrderId(order.getOrderId()).orElseThrow(() -> new DataException(format("No record found [orderId=%s]", order.getOrderId())));
        mapper.save(order);
    }

    public void delete(Order order) {
        mapper.delete(order);
    }

    public List<Order> list() {
        return mapper.scan(Order.class, new DynamoDBScanExpression());
    }

    public Optional<Order> getByOrderId(String orderId) {
        return ofNullable(mapper.load(Order.class, orderId));
    }

    private AmazonDynamoDB remoteDb() {
        return standard().build();
    }

    private AmazonDynamoDB localDb() {
        return AmazonDynamoDBClient.builder()
                .withEndpointConfiguration(localEndpoint())
                .build();
    }

    private boolean isLocal() {
        return "true".equals(System.getenv("AWS_SAM_LOCAL"));
    }

}

package bhuwanupadhyay.dynamodb.streams.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Order {

    public static final ObjectMapper MAPPER = new ObjectMapper();
    @DynamoDBHashKey
    private String orderId;
    private String customerId;
    private String orderStatus;


    @SneakyThrows
    public static Order of(String payload) {
        return MAPPER.readValue(payload, Order.class);
    }

    public void markAs(OrderStatus status) {
        this.orderStatus = status.name();
    }

}

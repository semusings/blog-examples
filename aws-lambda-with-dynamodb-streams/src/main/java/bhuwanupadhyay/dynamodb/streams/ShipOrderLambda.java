package bhuwanupadhyay.dynamodb.streams;

import bhuwanupadhyay.dynamodb.streams.data.DataException;
import bhuwanupadhyay.dynamodb.streams.data.Order;
import bhuwanupadhyay.dynamodb.streams.data.OrderRepository;
import bhuwanupadhyay.dynamodb.streams.data.OrderStatus;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import lombok.extern.slf4j.Slf4j;

import static java.lang.String.format;
import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@Slf4j
public class ShipOrderLambda implements RequestHandler<DynamodbEvent, Response> {

    private final OrderRepository repository = new OrderRepository();

    @Override
    public Response<String> handleRequest(DynamodbEvent input, Context context) {
        try {
            input.getRecords()
                    .forEach(record -> {
                        if ("MODIFY".equals(record.getEventName())) {
                            AttributeValue orderId = record.getDynamodb().getKeys().get("orderId");
                            AttributeValue orderStatus = record.getDynamodb().getNewImage().get("orderStatus");
                            if (OrderStatus.READY.name().equals(orderStatus.getS())) {
                                LOG.info("Shipping order for orderId : " + orderId);
                                Order order = repository.getByOrderId(orderId.getS())
                                        .orElseThrow(() -> new DataException(format("No record found [orderId=%s]", orderId.getS())));
                                order.markAs(OrderStatus.SHIPPED);
                                repository.update(order);
                                LOG.info("Shipped!");
                            }
                        }
                    });
            return Response.ok("Payment Processed Successfully");
        } catch (Exception e) {
            return Response.error(getStackTrace(e));
        }
    }

}

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

import static bhuwanupadhyay.dynamodb.streams.data.OrderStatus.PLACED;
import static java.lang.String.format;
import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@Slf4j
public class ProcessPaymentLambda implements RequestHandler<DynamodbEvent, Response> {

    private final OrderRepository repository = new OrderRepository();

    @Override
    public Response<String> handleRequest(DynamodbEvent input, Context context) {
        try {
            input.getRecords()
                    .forEach(record -> {
                        if ("INSERT".equals(record.getEventName())) {
                            final String orderId = record.getDynamodb().getKeys().get("orderId").getS();
                            AttributeValue orderStatus = record.getDynamodb().getNewImage().get("orderStatus");
                            if (PLACED.name().equals(orderStatus.getS())) {
                                LOG.info("Processing payment for order : " + orderId);
                                Order order = repository.getByOrderId(orderId)
                                        .orElseThrow(() -> new DataException(format("No record found [orderId=%s]", orderId)));
                                order.markAs(OrderStatus.PAID);
                                repository.update(order);
                                LOG.info("Payment Done!");
                            }
                        }
                    });
            return Response.ok("Payment Processed Successfully");
        } catch (Exception e) {
            return Response.error(getStackTrace(e));
        }
    }

}

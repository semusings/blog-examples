package bhuwanupadhyay.dynamodb.streams;

import bhuwanupadhyay.dynamodb.streams.data.Order;
import bhuwanupadhyay.dynamodb.streams.data.OrderRepository;
import bhuwanupadhyay.dynamodb.streams.data.OrderStatus;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.apache.http.HttpStatus;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

public class ReceiveOrderLambda implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final OrderRepository repository = new OrderRepository();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        try {
            Order order = Order.of(input.getBody());
            this.placeOrder(order);
            responseEvent.setStatusCode(HttpStatus.SC_CREATED);
            responseEvent.setBody(Response.ok("Order created with id: " + order.getOrderId()).toJSON());
        } catch (Exception e) {
            responseEvent.setBody(Response.error(getStackTrace(e)).toJSON());
            responseEvent.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
        return responseEvent;
    }

    private void placeOrder(Order order) {
        order.markAs(OrderStatus.PLACED);
        repository.persist(order);
    }

}

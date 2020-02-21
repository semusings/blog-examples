package bhuwanupadhyay.aws.lambda.apigateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.Map;

@SuppressWarnings("WeakerAccess")
@Data
public class ApiGatewayRequest {

    static final ObjectMapper MAPPER = new ObjectMapper();

    private String resource;
    private String path;
    private String httpMethod;
    private Map<String, String> headers;
    private Map<String, String> queryStringParameters;
    private Map<String, String> pathParameters;
    private Map<String, String> stageVariables;
    private Map<String, Object> requestContext;
    private String body;
    private boolean isBase64Encoded;

    @SneakyThrows
    public <T> T toBody(Class<T> valueType) {
        return MAPPER.readValue(body, valueType);
    }
}

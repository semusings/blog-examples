package bhuwanupadhyay.dynamodb.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.Date;

@SuppressWarnings("WeakerAccess")
@Data
public class Response<T> {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private T body;
    private String errorMessage;
    private Date generatedAt;

    public Response(T body) {
        this.body = body;
        this.generatedAt = new Date();
    }

    public static <T> Response<T> ok(T body) {
        return new Response<>(body);
    }

    public static <T> Response<T> error(String errorMessage) {
        Response<T> response = new Response<>(null);
        response.setErrorMessage(errorMessage);
        return response;
    }

    @SneakyThrows
    public String toJSON() {
        return MAPPER.writeValueAsString(this);
    }
}

package bhuwanupadhyay.stepfunctions;

import bhuwanupadhyay.stepfunctions.payload.SendNotification;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.util.IOUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SendNotificationFunction implements RequestStreamHandler {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        context.getLogger().log(IOUtils.toString(input));
        output.write(MAPPER.writeValueAsBytes(new SendNotification(true, 121)));
    }
}

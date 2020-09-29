package net.dilwit.springserverless.vanilla.controller.apigateway.specific.imperative;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import net.dilwit.springserverless.vanilla.model.Vanilla;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.function.Function;

import static net.dilwit.springserverless.vanilla.TestObjectUtil.getTestVanillaObjectAsAPIGatewayRequestEvent;
import static net.dilwit.springserverless.vanilla.TestObjectUtil.getTestVanillaResponseObject;

@ExtendWith(SpringExtension.class)
@FunctionalSpringBootTest
public class GatewaySpecificImperativeFunctionTest {

    @Autowired
    private FunctionCatalog functionCatalog;

    @Autowired
    private Gson gson;

    @Test
    public void shouldReturn400_WhenInvalidValuesProvided() {
        Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> function = functionCatalog.lookup(Function.class, "gatewaySpecificImperativeFunction");
        APIGatewayProxyRequestEvent requestEvent = new APIGatewayProxyRequestEvent();
        requestEvent.setBody(gson.toJson(new Vanilla("")));

        APIGatewayProxyResponseEvent responseEvent = function.apply(requestEvent);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(),responseEvent.getStatusCode());
    }

    @Test
    public void shouldReturn500_WhenInternalProcessingErrorOccurred() {
        Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> function = functionCatalog.lookup(Function.class, "gatewaySpecificImperativeFunction");
        APIGatewayProxyRequestEvent requestEvent = new APIGatewayProxyRequestEvent();
        requestEvent.setBody(gson.toJson(new Vanilla("return-internal-error")));

        APIGatewayProxyResponseEvent responseEvent = function.apply(requestEvent);
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(),responseEvent.getStatusCode());
        Assertions.assertTrue(responseEvent.getBody().contains("-can not process vanilla"));
    }

    @Test
    public void shouldReturn200_WhenValidInputIsProvided() {
        Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> function = functionCatalog.lookup(Function.class, "gatewaySpecificImperativeFunction");
        APIGatewayProxyResponseEvent responseEvent = function.apply(getTestVanillaObjectAsAPIGatewayRequestEvent());
        Assertions.assertEquals(HttpStatus.OK.value(),responseEvent.getStatusCode());
        Assertions.assertTrue(responseEvent.getBody().contains(getTestVanillaResponseObject().getName()));
    }

}

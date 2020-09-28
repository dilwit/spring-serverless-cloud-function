package net.dilwit.springserverless.vanilla.controller.apigateway.specific.imperative;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import net.dilwit.springserverless.vanilla.model.Vanilla;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class GatewaySpecificRequestResponseHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
}
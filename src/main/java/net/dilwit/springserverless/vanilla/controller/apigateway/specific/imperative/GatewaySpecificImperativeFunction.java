package net.dilwit.springserverless.vanilla.controller.apigateway.specific.imperative;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import net.dilwit.springserverless.vanilla.model.Vanilla;
import net.dilwit.springserverless.vanilla.service.VanillaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.function.Function;

@Component
public class GatewaySpecificImperativeFunction implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final Logger logger = LoggerFactory.getLogger(GatewaySpecificImperativeFunction.class);

    private final VanillaService vanillaService;
    private final Gson gson;

    @Autowired
    public GatewaySpecificImperativeFunction(VanillaService vanillaService, Gson gson) {
        this.vanillaService = vanillaService;
        this.gson = gson;
    }

    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent requestEvent) {
        logger.info("GatewaySpecificImperativeFunction in processing");
        Vanilla vanillaRequest = gson.fromJson(requestEvent.getBody(), Vanilla.class);

        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setStatusCode(HttpStatus.OK.value());
        Vanilla vanillaResponse = new Vanilla();

        if(StringUtils.isEmpty(vanillaRequest.getName())) {
            vanillaResponse.setName(vanillaRequest.getName() + "-validation error");
            responseEvent.setStatusCode(HttpStatus.BAD_REQUEST.value());
        } else if(vanillaRequest.getName().equals("return-internal-error")) {
            vanillaResponse.setName(vanillaRequest.getName() + "-can not process vanilla");
            responseEvent.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        } else {
            vanillaResponse = vanillaService.processVanilla(vanillaRequest);
        }

        responseEvent.setBody(gson.toJson(vanillaResponse));
        logger.info("GatewaySpecificImperativeFunction ends processing");
        return responseEvent;
    }
}

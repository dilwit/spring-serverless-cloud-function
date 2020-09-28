package net.dilwit.springserverless.vanilla.controller.apigateway.specific.imperative;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.google.gson.Gson;
import net.dilwit.springserverless.vanilla.model.Vanilla;
import net.dilwit.springserverless.vanilla.service.VanillaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class GatewaySpecificImperativeConsumer implements Consumer<APIGatewayProxyRequestEvent> {

    private final Logger logger = LoggerFactory.getLogger(GatewaySpecificImperativeSupplier.class);

    private final VanillaService vanillaService;
    private final Gson gson;

    @Autowired
    public GatewaySpecificImperativeConsumer(VanillaService vanillaService, Gson gson) {
        this.vanillaService = vanillaService;
        this.gson = gson;
    }

    @Override
    public void accept(APIGatewayProxyRequestEvent requestEvent) {
        logger.info("GatewaySpecificImperativeConsumer in processing");
        // TODO
        logger.info("GatewaySpecificImperativeConsumer ends processing");
    }
}

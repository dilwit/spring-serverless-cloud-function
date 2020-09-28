package net.dilwit.springserverless.vanilla.controller.apigateway.specific.imperative;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import net.dilwit.springserverless.vanilla.model.Vanilla;
import net.dilwit.springserverless.vanilla.service.VanillaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;

@Component
public class GatewaySpecificImperativeSupplier implements Supplier<APIGatewayProxyResponseEvent> {

    private final Logger logger = LoggerFactory.getLogger(GatewaySpecificImperativeSupplier.class);

    private final VanillaService vanillaService;
    private final Gson gson;

    @Autowired
    public GatewaySpecificImperativeSupplier(VanillaService vanillaService, Gson gson) {
        this.vanillaService = vanillaService;
        this.gson = gson;
    }

    @Override
    public APIGatewayProxyResponseEvent get() {
        logger.info("GatewayImperativeSupplier ends processing");
        // TODO
        return null;
    }
}

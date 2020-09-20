package net.dilwit.springserverless.vanilla.controller.apigateway.imperative;

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

import java.util.function.Function;

@Component
public class GatewayImperativeFunction implements Function<Message<Vanilla>, Message<Vanilla>> {

    private final Logger logger = LoggerFactory.getLogger(GatewayImperativeFunction.class);

    private final VanillaService vanillaService;
    private final Gson gson;

    @Autowired
    public GatewayImperativeFunction(VanillaService vanillaService, Gson gson) {
        this.vanillaService = vanillaService;
        this.gson = gson;
    }

    @Override
    public Message<Vanilla> apply(Message<Vanilla> message) {
        logger.info("GatewayImperativeFunction in processing");
        Vanilla vanilla = message.getPayload();
        vanilla = vanillaService.processVanilla(vanilla);
        logger.info("GatewayImperativeFunction ends processing");
        return MessageBuilder.withPayload(vanilla).setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }
}

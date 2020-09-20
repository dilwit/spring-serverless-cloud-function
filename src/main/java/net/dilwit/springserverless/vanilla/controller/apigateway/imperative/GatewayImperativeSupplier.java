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

import java.util.List;
import java.util.function.Supplier;

@Component
public class GatewayImperativeSupplier implements Supplier<Message<List<Vanilla>>> {

    private final Logger logger = LoggerFactory.getLogger(GatewayImperativeSupplier.class);

    private final VanillaService vanillaService;
    private final Gson gson;

    @Autowired
    public GatewayImperativeSupplier(VanillaService vanillaService, Gson gson) {
        this.vanillaService = vanillaService;
        this.gson = gson;
    }

    @Override
    public Message<List<Vanilla>> get() {
        logger.info("GatewayImperativeSupplier ends processing");
        Message<List<Vanilla>> vanillaResponse = MessageBuilder.withPayload(vanillaService.getList()).setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        return vanillaResponse;
    }
}

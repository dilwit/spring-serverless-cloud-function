package net.dilwit.springserverless.vanilla.controller.apigateway.generic.imperative;

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
public class GatewayGenericImperativeConsumer implements Consumer<Message<Vanilla>> {

    private final Logger logger = LoggerFactory.getLogger(GatewayGenericImperativeSupplier.class);

    private final VanillaService vanillaService;
    private final Gson gson;

    @Autowired
    public GatewayGenericImperativeConsumer(VanillaService vanillaService, Gson gson) {
        this.vanillaService = vanillaService;
        this.gson = gson;
    }

    @Override
    public void accept(Message<Vanilla> message) {
        logger.info("GatewayImperativeConsumer in processing");
        Vanilla vanilla = message.getPayload();
        vanillaService.readVanilla(vanilla);
        logger.info("GatewayImperativeConsumer ends processing");
    }
}

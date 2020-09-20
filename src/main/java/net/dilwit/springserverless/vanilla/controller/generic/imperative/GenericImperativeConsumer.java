package net.dilwit.springserverless.vanilla.controller.generic.imperative;

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
public class GenericImperativeConsumer implements Consumer<Vanilla> {

    private final Logger logger = LoggerFactory.getLogger(GenericImperativeSupplier.class);

    private final VanillaService vanillaService;
    private final Gson gson;

    @Autowired
    public GenericImperativeConsumer(VanillaService vanillaService, Gson gson) {
        this.vanillaService = vanillaService;
        this.gson = gson;
    }

    @Override
    public void accept(Vanilla vanilla) {
        logger.info("GenericImperativeConsumer in processing");
        vanillaService.readVanilla(vanilla);
        logger.info("GenericImperativeConsumer ends processing");
    }
}

package net.dilwit.springserverless.vanilla.controller.generic.imperative;

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
public class GenericImperativeFunction implements Function<Vanilla, Vanilla> {

    private final Logger logger = LoggerFactory.getLogger(GenericImperativeFunction.class);

    private final VanillaService vanillaService;
    private final Gson gson;

    @Autowired
    public GenericImperativeFunction(VanillaService vanillaService, Gson gson) {
        this.vanillaService = vanillaService;
        this.gson = gson;
    }

    @Override
    public Vanilla apply(Vanilla vanilla) {
        logger.info("GenericImperativeFunction in processing");
        vanilla = vanillaService.processVanilla(vanilla);
        logger.info("GenericImperativeFunction ends processing");
        return vanilla;
    }
}

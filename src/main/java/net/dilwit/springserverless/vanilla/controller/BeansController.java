package net.dilwit.springserverless.vanilla.controller;

import net.dilwit.springserverless.vanilla.model.Vanilla;
import net.dilwit.springserverless.vanilla.service.VanillaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class BeansController {

    Logger logger = LoggerFactory.getLogger(BeansController.class);

    private final VanillaService vanillaService;

    @Autowired
    public BeansController(VanillaService vanillaService) {
        this.vanillaService = vanillaService;
    }

    @Bean
    public Function<Vanilla, Vanilla> functionAsBean() {
        return input -> vanillaService.processVanilla(input);
    }

    @Bean
    public Consumer<Vanilla> consumerAsBean() {
        return input -> vanillaService.readVanilla(input);
    }

    @Bean
    public Supplier<List<Vanilla>> supplierAsBean() {
        return () -> vanillaService.getVanilla();
    }
}

package net.dilwit.springserverless.vanilla.controller;

import net.dilwit.springserverless.vanilla.model.Vanilla;
import net.dilwit.springserverless.vanilla.service.VanillaService;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class ConsumerAsClass implements Consumer<Vanilla> {

    private final VanillaService vanillaService;

    public ConsumerAsClass(VanillaService vanillaService) {
        this.vanillaService = vanillaService;
    }

    @Override
    public void accept(Vanilla vanilla) {
        vanillaService.readVanilla(vanilla);
    }
}

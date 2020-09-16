package net.dilwit.springserverless.vanilla.controller;

import net.dilwit.springserverless.vanilla.model.Vanilla;
import net.dilwit.springserverless.vanilla.service.VanillaService;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FunctionAsClass implements Function<Vanilla, Vanilla> {

    private final VanillaService vanillaService;

    public FunctionAsClass(VanillaService vanillaService) {
        this.vanillaService = vanillaService;
    }

    @Override
    public Vanilla apply(Vanilla vanilla) {
        return vanillaService.processVanilla(vanilla);
    }
}

package net.dilwit.springserverless.vanilla.controller;

import net.dilwit.springserverless.vanilla.model.Vanilla;
import net.dilwit.springserverless.vanilla.service.VanillaService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class SupplierAsClass implements Supplier<List<Vanilla>> {

    private final VanillaService vanillaService;

    public SupplierAsClass(VanillaService vanillaService) {
        this.vanillaService = vanillaService;
    }

    @Override
    public List<Vanilla> get() {
        return vanillaService.getVanilla();
    }
}

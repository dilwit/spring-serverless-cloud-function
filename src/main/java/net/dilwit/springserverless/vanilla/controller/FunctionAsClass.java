package net.dilwit.springserverless.vanilla.controller;

import lombok.SneakyThrows;
import net.dilwit.springserverless.vanilla.model.Vanilla;
import net.dilwit.springserverless.vanilla.service.VanillaService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.function.Function;

@Component
public class FunctionAsClass implements Function<Vanilla, Vanilla> {

    private final VanillaService vanillaService;

    public FunctionAsClass(VanillaService vanillaService) {
        this.vanillaService = vanillaService;
    }

    @SneakyThrows
    @Override
    public Vanilla apply(Vanilla vanilla) {
        if(StringUtils.isEmpty(vanilla.getName()))
            throw new MissingServletRequestParameterException("name","String");

        if(vanilla.getName().equals("return-internal-error"))
            throw new RuntimeException("Can not process vanilla");

        return vanillaService.processVanilla(vanilla);
    }
}

package net.dilwit.springserverless.vanilla.controller.generic;

import net.dilwit.springserverless.vanilla.model.Vanilla;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class GenericHandler extends SpringBootRequestHandler<Vanilla, Vanilla> {
}
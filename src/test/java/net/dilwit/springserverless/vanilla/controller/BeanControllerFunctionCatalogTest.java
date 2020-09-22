package net.dilwit.springserverless.vanilla.controller;

import net.dilwit.springserverless.vanilla.model.Vanilla;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.function.Function;

import static net.dilwit.springserverless.vanilla.TestObjectUtil.getTestVanillaObject;
import static net.dilwit.springserverless.vanilla.TestObjectUtil.getTestVanillaResponseObject;

@ExtendWith(SpringExtension.class)
@FunctionalSpringBootTest
public class BeanControllerFunctionCatalogTest {

    @Autowired
    private FunctionCatalog functionCatalog;

    @Test
    public void testFunctionAsBean_shouldReturnProcessVanillaWhenValidVanillaProvided() {
        Function<Vanilla, Vanilla> functionAsBean = functionCatalog.lookup(Function.class, "functionAsBean");
        Vanilla vanilla = functionAsBean.apply(getTestVanillaObject());
        Assertions.assertTrue(vanilla.getName().equals(getTestVanillaResponseObject().getName()));
    }
}

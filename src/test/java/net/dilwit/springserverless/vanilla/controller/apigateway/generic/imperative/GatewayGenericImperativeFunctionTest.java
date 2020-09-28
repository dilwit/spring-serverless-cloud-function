package net.dilwit.springserverless.vanilla.controller.apigateway.generic.imperative;

import net.dilwit.springserverless.vanilla.model.Vanilla;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.function.Function;

import static net.dilwit.springserverless.vanilla.TestObjectUtil.getTestVanillaObjectAsMessage;
import static net.dilwit.springserverless.vanilla.TestObjectUtil.getTestVanillaResponseObject;

@ExtendWith(SpringExtension.class)
@FunctionalSpringBootTest
public class GatewayGenericImperativeFunctionTest {

    @Autowired
    private FunctionCatalog functionCatalog;

    @Test
    public void testFunctionAsBean_shouldReturnProcessVanillaWhenValidVanillaProvided() {
        Function<Message, Message> functionAsBean = functionCatalog.lookup(Function.class, "gatewayGenericImperativeFunction");
        Message<Vanilla> responseMessage = functionAsBean.apply(getTestVanillaObjectAsMessage());
        Assertions.assertTrue(responseMessage.getPayload().getName().equals(getTestVanillaResponseObject().getName()));
    }

}

package net.dilwit.springserverless.vanilla.controller.apigateway.specific.imperative;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@FunctionalSpringBootTest
public class GatewaySpecificImperativeFunctionTest {

    @Autowired
    private FunctionCatalog functionCatalog;

}

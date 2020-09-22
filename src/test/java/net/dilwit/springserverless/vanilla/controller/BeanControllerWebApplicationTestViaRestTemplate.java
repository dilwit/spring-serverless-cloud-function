package net.dilwit.springserverless.vanilla.controller;

import net.dilwit.springserverless.vanilla.VanillaApplication;
import net.dilwit.springserverless.vanilla.model.Vanilla;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static net.dilwit.springserverless.vanilla.TestObjectUtil.*;

@SpringBootTest(
        classes = VanillaApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BeanControllerWebApplicationTestViaRestTemplate {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testFunctionAsBean_shouldReturn200WhenCorrectInputIsProvided() {
        ResponseEntity<Vanilla> responseEntity = restTemplate.postForEntity("/functionAsBean", getTestVanillaObjectAsHttpEntity(), Vanilla.class);
        Assertions.assertTrue(responseEntity.getStatusCode().equals(HttpStatus.OK));
        Assertions.assertTrue(responseEntity.getBody().toString().equals(getTestVanillaResponseObject().toString()));
    }

}

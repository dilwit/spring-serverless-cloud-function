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

import static net.dilwit.springserverless.vanilla.TestObjectUtil.getTestVanillaObjectAsHttpEntity;
import static net.dilwit.springserverless.vanilla.TestObjectUtil.getTestVanillaResponseObject;

@SpringBootTest(
        classes = VanillaApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FunctionAsClassTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturn404_WhenIncorrectUrlProvided() {
        ResponseEntity<Vanilla> responseEntity = restTemplate.postForEntity("/functionAsXXX", null, Vanilla.class);
        Assertions.assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
    }

    @Test
    public void shouldReturn400_WhenInvalidValuesProvided() {
        ResponseEntity<Vanilla> responseEntity = restTemplate.postForEntity("/functionAsClass", new Vanilla(""), Vanilla.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

    @Test
    public void shouldReturn500_WhenEmptyBodyIsProvided() {
        ResponseEntity<Vanilla> responseEntity = restTemplate.postForEntity("/functionAsClass", null, Vanilla.class);
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,responseEntity.getStatusCode());
        Assertions.assertTrue(responseEntity.getBody().getName().equals("custom error: error in processing"));
    }

    @Test
    public void shouldReturn500_WhenInternalProcessingErrorOccurred() {
        ResponseEntity<Vanilla> responseEntity = restTemplate.postForEntity("/functionAsClass", new Vanilla("return-internal-error"), Vanilla.class);
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,responseEntity.getStatusCode());
        Assertions.assertTrue(responseEntity.getBody().getName().equals("custom error: error in processing"));
    }

    @Test
    public void shouldReturn200_WhenValidInputIsProvided() {
        ResponseEntity<Vanilla> responseEntity = restTemplate.postForEntity("/functionAsClass", getTestVanillaObjectAsHttpEntity(), Vanilla.class);
        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        Assertions.assertTrue(responseEntity.getBody().toString().equals(getTestVanillaResponseObject().toString()));
    }
}

package net.dilwit.springserverless.vanilla.controller;

import net.dilwit.springserverless.vanilla.model.Vanilla;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@FunctionalSpringBootTest
@AutoConfigureWebTestClient
public class BeanControllerTest {

    @Autowired
    private WebTestClient client;

    @Test
    public void testFunctionAsBean_shouldReturn200WhenCorrectInputIsProvided() {
        client.post().uri("/functionAsBean").body(Mono.just(getTestVanillaObject()), Vanilla.class)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().toString().equals(getTestVanillaObject().toString());
    }

    private static Vanilla getTestVanillaObject() {
        return new Vanilla("test-vanilla");
    }

}

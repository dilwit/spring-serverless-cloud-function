package net.dilwit.springserverless.vanilla.controller;

import net.dilwit.springserverless.vanilla.VanillaApplication;
import net.dilwit.springserverless.vanilla.model.Vanilla;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static net.dilwit.springserverless.vanilla.TestObjectUtil.getTestVanillaObject;
import static net.dilwit.springserverless.vanilla.TestObjectUtil.getTestVanillaResponseObject;

@ExtendWith(SpringExtension.class)
@SpringBootTest (classes = VanillaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class BeanControllerWebApplicationTestViaWebClient {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testFunctionAsBean_shouldReturn200WhenCorrectInputIsProvided() {
        webTestClient.post().uri("/functionAsBean").body(Mono.just(getTestVanillaObject()), Vanilla.class)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.name").isEqualTo(getTestVanillaResponseObject().getName());
    }
}

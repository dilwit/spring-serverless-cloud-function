package net.dilwit.springserverless.vanilla;

import net.dilwit.springserverless.vanilla.model.Vanilla;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class TestObjectUtil {

    public static Message<Vanilla> getTestVanillaObjectAsMessage() {
        return MessageBuilder.withPayload(getTestVanillaObject()).setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }

    public static Vanilla getTestVanillaObject() {
        return new Vanilla("test-vanilla");
    }

    public static Vanilla getTestVanillaResponseObject() {
        return new Vanilla("test-vanilla-processed");
    }
}

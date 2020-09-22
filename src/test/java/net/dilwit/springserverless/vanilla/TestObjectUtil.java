package net.dilwit.springserverless.vanilla;

import net.dilwit.springserverless.vanilla.model.Vanilla;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class TestObjectUtil {

    public static HttpEntity getTestVanillaObjectAsHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(getTestVanillaObject(), headers);
        return entity;
    }

    public static Vanilla getTestVanillaObject() {
        return new Vanilla("test-vanilla");
    }

    public static Vanilla getTestVanillaResponseObject() {
        return new Vanilla("test-vanilla-processed");
    }
}

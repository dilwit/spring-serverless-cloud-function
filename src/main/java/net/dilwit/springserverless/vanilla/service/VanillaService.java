package net.dilwit.springserverless.vanilla.service;


import net.dilwit.springserverless.vanilla.model.Vanilla;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VanillaService {

    Logger logger = LoggerFactory.getLogger(VanillaService.class);

    public Vanilla processVanilla(Vanilla vanilla) {
        return new Vanilla(vanilla.getName() + "-processed");
    }

    public void readVanilla(Vanilla vanilla) {
        logger.info("Hello, I can see what you send me -> " + vanilla.toString());
    }

    public List<Vanilla> getVanilla() {
        List<Vanilla> samples = new ArrayList<>();
        samples.add(new Vanilla("bean 1"));
        samples.add(new Vanilla("bean 2"));
        samples.add(new Vanilla("bean 3"));
        return samples;
    }
}

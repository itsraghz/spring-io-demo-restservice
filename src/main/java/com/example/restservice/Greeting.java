package com.example.restservice;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class Greeting {

    private static final Logger logger
            = LoggerFactory.getLogger(Greeting.class);

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        logger.info("Greeting instance created");
        this.id = id;
        this.content = content;
    }
}

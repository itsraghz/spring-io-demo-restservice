package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackTest {
    private static final Logger logger
            = LoggerFactory.getLogger(LogBackTest.class);

    public static void main(String[] args) {
        logger.info("Example log from {}", LogBackTest.class.getSimpleName());
    }
}
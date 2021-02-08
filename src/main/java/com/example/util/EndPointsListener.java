package com.example.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;

@Component
public class EndPointsListener {

    //private static final Logger LOGGER = LoggerFactory.getLogger(EndpointsListener.class);

    List<String> urlList = new ArrayList<>();

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        System.out.println("[EndPointsListener] contextRefreshed");
        /*ApplicationContext applicationContext = event.getApplicationContext();
        applicationContext.getBean(RequestMappingHandlerMapping.class)
                .getHandlerMethods().forEach((key, value) -> System.out.println("[EndPointsListener] key --> " + value));*/
    }
}

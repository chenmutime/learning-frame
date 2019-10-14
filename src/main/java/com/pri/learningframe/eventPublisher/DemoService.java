package com.pri.learningframe.eventPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class DemoService {

    @Autowired(required = false)
    private ApplicationEventPublisher applicationEventPublisher;

    public void service(DataEvent dataEvent) {
        applicationEventPublisher.publishEvent(dataEvent);
    }

}

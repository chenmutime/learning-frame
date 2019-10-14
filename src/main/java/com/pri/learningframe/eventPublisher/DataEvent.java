package com.pri.learningframe.eventPublisher;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class DataEvent extends ApplicationEvent {

    private String eventType;

    public DataEvent(String eventType, Object source) {
        super(source);
        this.eventType = eventType;
    }
}

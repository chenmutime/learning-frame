package com.pri.learningframe.disruptor;

import com.lmax.disruptor.EventFactory;


public class CustomEventFactory implements EventFactory<CustomEvent> {

    public CustomEvent newInstance() {

        return new CustomEvent();
    }
}

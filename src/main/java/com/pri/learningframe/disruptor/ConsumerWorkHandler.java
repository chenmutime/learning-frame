package com.pri.learningframe.disruptor;


import com.lmax.disruptor.WorkHandler;

public class ConsumerWorkHandler implements WorkHandler<CustomEvent> {

    public void onEvent(CustomEvent customEvent) throws Exception {
        System.out.println(""+customEvent.getContent());
    }
}

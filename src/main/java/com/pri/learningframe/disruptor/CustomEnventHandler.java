package com.pri.learningframe.disruptor;


import com.lmax.disruptor.EventHandler;

public class CustomEnventHandler implements EventHandler<CustomEvent> {
    public void onEvent(CustomEvent customEvent, long l, boolean b) throws Exception {
        System.out.println(customEvent.getType()+"被处理");
    }
}

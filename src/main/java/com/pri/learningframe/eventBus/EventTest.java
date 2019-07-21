package com.pri.learningframe.eventBus;

import com.google.common.eventbus.EventBus;
import org.junit.Test;


public class EventTest {

    @Test
    public void test(){
        EventBus eventBus = new EventBus("test");
        UserEventListener userEventListener = new UserEventListener();

//        EventBus会判断UserEventListener中加入了@Subscribe的方法，并加入到本地集合
        eventBus.register(userEventListener);

        UserEvent userEvent1 = new UserEvent();
        userEvent1.setAge("22");
        userEvent1.setName("hmm");
//        EventBus遍历保存在集合中的监听器，通过反射调用监听器中加入了@Subscribe的方法，并以UserEvent作为参数传进去
        eventBus.post(userEvent1);

        System.out.println(userEventListener.getUserEvent().getAge()+"::"+userEventListener.getUserEvent().getName());
    }
}

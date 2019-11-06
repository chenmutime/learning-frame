package com.pri.learningframe.eventPublisher;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandlerDispatcher2 implements ApplicationListener<DataEvent> {
    @Override
    public void onApplicationEvent(DataEvent dataEvent) {
        if ("order".equals(dataEvent.getEventType())) {
//            调用响应的事件消费服务
            System.out.println(">>>>>>>>>>>>执行事件消费业务2：" + dataEvent.getSource());
        }
    }
}

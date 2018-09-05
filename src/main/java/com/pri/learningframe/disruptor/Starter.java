package com.pri.learningframe.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Starter {

    static Disruptor<CustomEvent> disruptor = null;

    public static void main(String[] args) {
        int ringBufferSize = 1024;
        ThreadPoolExecutor threadFactory = new ThreadPoolExecutor(9, 9,
                1000L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        EventFactory<CustomEvent> eventFactory = new CustomEventFactory();
//        单个生产线程使用ProducerType.SINGLE
        disruptor = new Disruptor<CustomEvent>(eventFactory, ringBufferSize, threadFactory.getThreadFactory(), ProducerType.SINGLE, new BlockingWaitStrategy());
//        定义一个事件处理器，比如记录一下事件消费消息
        disruptor.handleEventsWith(new CustomEnventHandler());
//        定义2个消费者线程
        disruptor.handleEventsWithWorkerPool(new ConsumerWorkHandler(), new ConsumerWorkHandler());
        disruptor.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer1();
        producer2();
    }

    public static void producer1() {
        RingBuffer<CustomEvent> ringBuffer = disruptor.getRingBuffer();
        long seq = ringBuffer.next();
        try {
//            定义事件处理对象
            CustomEvent customEvent = ringBuffer.get(seq);
            customEvent.setContent("cmtime");
            customEvent.setType("name");
        } finally {
            ringBuffer.publish(seq);
        }
    }

    public static void producer2() {
        RingBuffer<CustomEvent> ringBuffer = disruptor.getRingBuffer();
        long seq = ringBuffer.next();
        try {
//            定义事件处理对象
            CustomEvent customEvent = ringBuffer.get(seq);
            customEvent.setContent("cmtime2");
            customEvent.setType("name2");
        } finally {
            ringBuffer.publish(seq);
        }
    }

}

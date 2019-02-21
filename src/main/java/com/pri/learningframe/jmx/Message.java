package com.pri.learningframe.jmx;

public class Message implements MessageMBean {
    private String content;
    @Override
    public String getGreeting() {
        return this.content;
    }

    @Override
    public void setGreeting(String content) {
        this.content=content;
    }
}

package com.pri.learningframe.eventBus;

import com.google.common.eventbus.Subscribe;

public class UserEventListener {

    public UserEvent userEvent;

    @Subscribe
    public void listen(UserEvent userEvent){
        this.userEvent=userEvent;
    }

    public UserEvent getUserEvent(){
        return this.userEvent;
    }
}

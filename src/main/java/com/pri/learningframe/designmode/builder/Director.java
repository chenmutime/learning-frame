package com.pri.learningframe.designmode.builder;

//执行者
public class Director {

    public void construct(Builder builder){
        builder.buildEye();
        builder.buildHose();
        builder.buildMouse();
    }
}

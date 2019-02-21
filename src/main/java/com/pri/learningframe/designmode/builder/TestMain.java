package com.pri.learningframe.designmode.builder;

public class TestMain {

    public static void main(String[] args){
        Builder builder = new DefaultBuilder();
        Director director = new Director();
        director.construct(builder);
        System.out.println(builder.getFace().getEye());
    }
}

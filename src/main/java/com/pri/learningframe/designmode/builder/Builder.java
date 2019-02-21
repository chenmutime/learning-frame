package com.pri.learningframe.designmode.builder;

public abstract class Builder {

    protected Face face = new Face();

    abstract void buildEye();

    abstract void buildHose();

    abstract void buildMouse();

    public Face getFace(){
        return face;
    }
}

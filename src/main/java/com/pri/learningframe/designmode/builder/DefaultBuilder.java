package com.pri.learningframe.designmode.builder;

public class DefaultBuilder extends Builder {

    private Face face = new Face();

    @Override
    void buildEye() {
        this.face.setEye("this is eye");
    }

    @Override
    void buildHose() {
        this.face.setHose("this is hose");
    }

    @Override
    void buildMouse() {
        this.face.setMouse("this is mouse");
    }

    @Override
    public Face getFace(){
        return face;
    }

}

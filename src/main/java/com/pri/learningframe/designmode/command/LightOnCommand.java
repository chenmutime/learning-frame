package com.pri.learningframe.designmode.command;

public class LightOnCommand implements Command{

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.setMode(1);
    }
}

package com.pri.learningframe.designmode.command;

public class CommandTest {

    public static void main(String[] args){
//        命令执行者
        Invoker invoker = new Invoker();
//        被执行者
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
//        设置命令对象
        invoker.setCommand(lightOnCommand);
//        执行命令
        invoker.doCommand();

    }

}

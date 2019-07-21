package com.pri.learningframe.designmode.command;

/**
 * 命令执行者
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void doCommand(){
        command.execute();
    }
}

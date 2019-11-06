package com.pri.learningframe.proxy;

@Color
public class Dog extends FourLegAnimal implements Animal {

    @Override
    public void run() {
        super.run();
        System.out.println("狗狗开始奔跑。。。");
    }
}

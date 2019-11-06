package com.pri.learningframe.proxy;

import org.springframework.core.annotation.AnnotationUtils;

public class ProxyTest {

    public static void main(String[] args) {
        Animal animal = new JDKDynamicProxy(new Dog()).getProxy();
        animal.run();
        System.out.println(AnnotationUtils.findAnnotation(animal.getClass(), Color.class));
    }
}

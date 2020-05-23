package com.demo.proxy;

import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        Showable target= context.getBean("target",Showable.class);
        target.show();
        target.display();


    }

}

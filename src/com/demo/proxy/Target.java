package com.demo.proxy;

public class Target implements Showable{
    public String name;
    @Override
    public void show() {
        System.out.println("this is show()");
    }

    @Override
    public String display() {
        System.out.println("this is display()");
        return "Display";
    }
}

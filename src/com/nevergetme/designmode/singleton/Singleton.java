package com.nevergetme.designmode.singleton;

public class Singleton {
    private static Singleton singleton=new Singleton();
    private Singleton(){
        System.out.println("create one constant");
    }
    public static Singleton getInstance(){
        return singleton;
    }
}

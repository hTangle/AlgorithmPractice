package com.nevergetme.designmode.template;

public class Main {
    public static void main(String[] args){
        AbstructDisplay d1=new CharDisplay('H');
        AbstructDisplay d2=new StringDisplay("Hello World");
        AbstructDisplay d3=new StringDisplay("你好，世界");
        d1.display();
        d2.display();
        d3.display();
    }
}

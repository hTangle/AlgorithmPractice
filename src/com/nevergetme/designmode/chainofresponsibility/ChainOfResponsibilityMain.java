package com.nevergetme.designmode.chainofresponsibility;

public class ChainOfResponsibilityMain {
    //一个典型的例子是鼠标点击界面的例子，鼠标点击事件发生以后，需要将这个事件传给能够处理该事件的对象
    public static void main(String[] args){
        Support alice=new NoSupport("Alice");
        Support bob=new LimitSupport("Bob",100);
        Support charlie=new SpecialSupport("Charlie",429);
        Support diana=new LimitSupport("Diana",200);
        Support elmo=new OddSupport("Elme");
        Support fred=new LimitSupport("Fred",300);
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        for(int i=0;i<500;i++){
            alice.support(new Trouble(i));
        }
    }
}

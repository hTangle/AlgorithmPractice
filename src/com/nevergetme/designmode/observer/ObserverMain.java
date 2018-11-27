package com.nevergetme.designmode.observer;

public class ObserverMain {
    public static void main(String[] args){
        NumberGenerator generator=new IncrementalNumberGenerator(10,50,5);
        Observer observer1=new DigitalObserver();
        Observer observer2=new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}

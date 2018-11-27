package com.nevergetme.designmode.observer;

public class DigitalObserver implements Observer {

    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("DigitalObserver:"+numberGenerator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

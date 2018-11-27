package com.nevergetme.designmode.observer;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int begin,end,step;
    //private int number;
    public IncrementalNumberGenerator(int begin,int end,int step){
        this.begin=begin;
        this.end=end;
        this.step=step;
    }
    @Override
    public int getNumber() {
        return begin;
    }

    @Override
    public void execute() {
        for(;begin<=end;begin+=step){
            notifyObservers();
        }
    }
}

package com.nevergetme.designmode.strategy;

public class AdjuetListEvenOdd extends AdjustList<Integer>{
    @Override
    public boolean isCutFlag(Integer integer) {
        return integer%2==0;
    }
}

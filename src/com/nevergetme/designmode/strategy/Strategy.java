package com.nevergetme.designmode.strategy;

public abstract interface Strategy {
    public abstract Hand nextHand();
    public abstract void study(boolean win);
}
